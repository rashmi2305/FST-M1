package AppiumActivities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;
    String strResult;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testScrolling() throws InterruptedException{
        //driver.findElement(AppiumBy.id("com.android.chrome:id/terms_accept")).click();
        Thread.sleep(5000);
        //driver.findElement(AppiumBy.id("com.android.chrome:id/negative_button")).click();
        Thread.sleep(5000);
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.get("https://www.training-support.net/selenium/lazy-loading");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));
       //Get the number of images shown in the view
        List<WebElement> imgElements = driver.findElements(AppiumBy.id("android.widget.Image"));
        System.out.println("No of images: "+imgElements.size());
        //Scroll to the card with Helen's post
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTestIntoView(\"helen\")"));
        //Get number of images shown on the screen after scrolling.
        imgElements = driver.findElements(AppiumBy.id("android.widget.Image"));
        System.out.println("No of images after scrolling: "+imgElements.size());
        Assert.assertEquals(imgElements.size(),5);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
