package AppiumActivities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver driver;
    String strResult;

    @BeforeClass
    public void setUp() throws MalformedURLException{
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");

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

    //Calculate 10 - 5 and print the result to the console.
    @Test
    public void operation_substract(){
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_0")).click();
        driver.findElement(By.id("op_sub")).click();
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        strResult = driver.findElement(By.id("result")).getText();
        System.out.println("10-5 is: "+strResult);
        Assert.assertEquals(strResult,"5");
    }

    //Calculate 5 * 100 and print the result to the console.
    @Test
    public void operation_multiply(){
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("op_mul")).click();
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("digit_0")).click();
        driver.findElement(By.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        strResult = driver.findElement(By.id("result")).getText();
        System.out.println("5*100 is: "+strResult);
        Assert.assertEquals(strResult,"500");
    }

    //Calculate 50 / 2 and print the result to the console.
    @Test
    public void operation_divide(){
        driver.findElement(By.id("digit_5")).click();
        driver.findElement(By.id("digit_0")).click();
        driver.findElement(By.id("op_div")).click();
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        strResult = driver.findElement(By.id("result")).getText();
        System.out.println("50/2 is: "+strResult);
        Assert.assertEquals(strResult,"25");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
