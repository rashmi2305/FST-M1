package AppiumActivities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;
    String strResult;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.PeopleActivity");

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    //Calculate 5 + 9 and print the result to the console.
    @Test
    public void operation_sum(){
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        strResult = driver.findElement(By.id("result")).getText();
        System.out.println("Sum of 5 and 9 is: "+strResult);
        Assert.assertEquals(strResult,"14");
    }

    //Find and click the button to add a new contact.
    //Find and fill the first name, last name, and phone number fields with the data provided.
    //Click on Save.
    //Write an assertion to ensure the new contact has been added
    @Test
    public void AddContact() throws InterruptedException{
            // Find and click the add button
            driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();

            // Wait for elements to load
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));

            // Enter the details
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");
            // Click Save
            driver.findElement(AppiumBy.id("editor_menu_save_button")).click();

            // Wait for contact to save
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));

            // Assertion
            String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
            Assert.assertEquals(contactName, "Aaditya Varma");
        }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}


