package AppiumActivities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException, InterruptedException{
        //Set desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        //Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        driver.get("https://www.training-support.net");
    }

    @Test
    public void Login() throws InterruptedException{
        driver.findElement(AppiumBy.id("com.android.chrome:id/terms_accept")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.id("com.android.chrome:id/negative_button")).click();
        Thread.sleep(5000);
        String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();
        System.out.println("Heading is: "+ pageHeading);
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']")).click();
        String aboutPageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText();
        System.out.println(aboutPageHeading);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
