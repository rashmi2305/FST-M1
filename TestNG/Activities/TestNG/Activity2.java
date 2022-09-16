package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void testMethod1(){
        String pgTitle = driver.getTitle();
        System.out.println("Page title is: " + pgTitle);
        Assert.assertEquals(pgTitle, "Target Practice");
    }

    @Test
    public void testMethod2(){
        WebElement objButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(objButton.isDisplayed());
        Assert.assertEquals(objButton.getText(), "Brown");
    }

    @Test(enabled = false)
    public void testMethod3(){
        System.out.println("This is the Test Case number Three");
    }

    @Test
    public void testMethod4() throws SkipException {
        String condition ="Skip Test";

        if(condition.equals("Skip Test")){
            throw new SkipException("Skipping - This is not ready for testing ");
        } else {
            System.out.println("This is the Test Case number Four");
        }
    }

    @AfterClass
    public void AfterMethod(){
        driver.quit();
    }

}
