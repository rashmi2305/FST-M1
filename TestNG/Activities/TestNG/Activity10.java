package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Activity10 {
    WebDriver driver;
    String strText;
    Actions builder;

    @BeforeClass
    public void beforeMethod(){
        driver = new FirefoxDriver();
        builder = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/sliders");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @Test (priority = 0)
    public void testMiddleValue(){
        Reporter.log("Middle Value Test case");
        WebElement slider = driver.findElement(By.id("slider"));
        //builder.clickAndHold(slider).moveByOffset(50,50).release().build().perform();
        builder.clickAndHold(slider).release().build().perform();
        System.out.println("Slider at Volume: "+driver.findElement(By.cssSelector("span#value")).getText());
        Reporter.log("Middle Value Test case ended");
    }

    @Test (priority = 1)
    public void testMaxValue(){
        Reporter.log("Max Value Test case");
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();
        System.out.println("Slider at Volume: "+driver.findElement(By.cssSelector("span#value")).getText());
        Reporter.log("Max Value Test case ended");
    }

    @Test (priority = 3)
    public void testMinValue(){
        Reporter.log("Min Value Test case");
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();
        Reporter.log("Min Value Test case ended");
    }

    @Test (priority = 4)
    public void test30PercentValue(){
        Reporter.log("30 Percent Value Test case");
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
        System.out.println("Slider at Volume: "+driver.findElement(By.cssSelector("span#value")).getText());
        Reporter.log("30 Percent Value Test case ended");
    }

    @Test (priority = 5)
    public void test80PercentValue(){
        Reporter.log("80 Percent Value Test case");
        WebElement slider = driver.findElement(By.id("slider"));
        //Drag the slider
        builder.clickAndHold(slider).moveByOffset(44, 0).release().build().perform();
        System.out.println("Slider at Volume: "+driver.findElement(By.cssSelector("span#value")).getText());
        Reporter.log("80 Percent Value Test case ended");
    }
    /*
    @AfterClass
    public void AfterMethod(){
        driver.quit();
    }*/
}
