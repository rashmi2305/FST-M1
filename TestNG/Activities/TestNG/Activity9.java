package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.Reporter;
import org.openqa.selenium.Alert;

import java.util.concurrent.TimeUnit;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    String strText;

    @BeforeClass
    public void setUp() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        Reporter.log("Starting Test |");
        //Open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened Browser |");

        //Print title of page
        Reporter.log("Page title is " + driver.getTitle() + " |");
    }

    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlertTestCase() {
        Reporter.log("Simple Alert TC");
        driver.findElement(By.id("simple")).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Reporter.log("switched focus to alert");
        strText = alert.getText();
        System.out.println("Simple Alert text message is: "+strText);
        alert.accept();
        Reporter.log("Alert Closed");
        Assert.assertEquals("This is a JavaScript Alert!", strText);
        Reporter.log("Simple Alert TC ended");
        /*
        Reporter.log("simpleAlertTestCase() started |");
        //Click the button to open a simple alert
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |");

        //Switch to alert window
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");

        //Get text in the alert box and print it
        String alertText = simpleAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");

        //Assertion
        Assert.assertEquals("This is a JavaScript Alert!", alertText);

        simpleAlert.accept();
        Reporter.log("Alert closed");

        Reporter.log("Test case ended |");
         */
    }

    @Test(priority = 1)
    public void confirmAlertTestCase() {
        Reporter.log("Confirm Alert TC");
        driver.findElement(By.id("confirm")).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        Reporter.log("Switched to Alert");
        strText = alert1.getText();
        System.out.println("Confirm Alert text message is: "+strText);
        alert1.accept();
        Reporter.log("Alert closed");
        Assert.assertEquals("This is a JavaScript Confirmation!", strText);
        Reporter.log("Confirm Alert TC ended");
    }

    @Test(priority = 2)
    public void promptAlertTestCase() {
        Reporter.log("Prompt Alert TC");
        driver.findElement(By.id("prompt")).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        Reporter.log("Switched to Alert");
        //strText = alert2.getText();
        //System.out.println("Confirm Alert text message is: "+strText);
        alert2.sendKeys("Yes, you are!");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        alert2.accept();
        Reporter.log("Alert closed");
        Reporter.log("Prompt Alert TC ended");
        //Assert.assertEquals("This is a JavaScript Alert!", strText);
    }

    @AfterClass
    public void tearDown() {
        Reporter.log("Ending Test |");
        //Close the driver
        driver.quit();
    }
}
