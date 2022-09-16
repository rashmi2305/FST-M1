package AppiumActivities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;
    String strResult;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void CreateMessage() throws InterruptedException{
        driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("recipient_text_view")));
        //Locate the contact fields and enter your own phone number to send a message to your own phone number.
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("7760625823");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        Thread.sleep(5000);
        //Locate the message input field and enter the message "Hello from Appium".
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        Thread.sleep(5000);
        //Locate the send button and click it.
        driver.findElement(AppiumBy.id("send_message_button_icon")).click();
        Thread.sleep(5000);
        //Write an assertion to verify that the message has been sent successfully.
        strResult = driver.findElement(AppiumBy.id("message_text")).getText();
        Assert.assertEquals(strResult, "Hello from Appium");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
