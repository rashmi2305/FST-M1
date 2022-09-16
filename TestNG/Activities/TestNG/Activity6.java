package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Parameters;

public class Activity6 {
    WebDriver driver;
    String strText;

    @BeforeClass
    public void beforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @Test
    public void getTitle(){
        strText = driver.getTitle();
        System.out.println("Title is: " + strText);
        Assert.assertEquals("Login Form", strText);
    }

    @Test (dependsOnMethods = {"getTitle"})
    @Parameters ({"strUsername", "strPassword"})
    public void Login(String strUsername, String strPassword){
        driver.findElement(By.id("username")).sendKeys(strUsername);
        driver.findElement(By.id("password")).sendKeys(strPassword);
        strText = driver.findElement(By.id("username")).getText();
        System.out.println("Username is: " + strText);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();
        strText = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Tile of new page is: " + strText);
        Assert.assertEquals("Welcome Back, admin", strText);
    }

    @AfterClass
    public void AfterMethod(){
        driver.quit();
    }
}
