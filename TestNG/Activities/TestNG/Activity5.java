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

public class Activity5 {
    WebDriver driver;
    String strText;

    @BeforeClass
    public void beforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @Test (groups = {"HeaderTests", "ButtonTests"})
    public void getTitle(){
        strText = driver.getTitle();
        System.out.println("Title is: " + strText);
        Assert.assertEquals("Target Practice", strText);
    }

    @Test (dependsOnMethods = {"getTitle"}, groups = {"HeaderTests"})
    //@Test (groups = {"HeaderTests"})
    public void HeaderTests1(){
        //Find the third header and assert the text in the h3 tag.
        strText = driver.findElement(By.id("third-header")).getText();
        System.out.println("third header text is: " + strText);
        Assert.assertEquals("Third header", strText);
    }

    @Test (dependsOnMethods = {"getTitle"}, groups = {"HeaderTests"})
    public void HeaderTests2(){
        //Find and assert the colour of the fifth header tag element
        strText = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5")).getText();
        System.out.println("Fifth header text is: " + strText);
        Assert.assertEquals("Fifth header", strText);
    }

    @Test (dependsOnMethods = {"getTitle"}, groups = {"ButtonTests"})
    public void ButtonTests1(){
        //Find the button with the class olive and assert it text.
        strText = driver.findElement(By.cssSelector("button.olive")).getText();
        System.out.println("button with the class olive is: " + strText);
        Assert.assertEquals("Olive", strText);
    }

    @Test (dependsOnMethods = {"getTitle"}, groups = {"ButtonTests"})
    public void ButtonTests2(){
        //Find and assert the colour of the first button in the third row.
        strText = driver.findElement(By.cssSelector("button.yellow")).getCssValue("background-color");
        System.out.println("colour of the first button in the third row is: " + strText);
        Assert.assertEquals("rgb(251, 189, 8)", strText);
    }

    @AfterClass
    public void AfterMethod(){
        driver.quit();
    }
}
