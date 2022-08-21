import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.concurrent.TimeUnit;


public class Activity6_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/ajax");
        System.out.println("Title of the page is: "+driver.getTitle());
        driver.findElement(By.linkText("Change Content")).click();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        /*
        if(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/h1")).getText() == "HELLO!"){
            System.out.println("Hello is printed");
        }else{
            System.out.println("Hello is not printed");
        }
        */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/h1")).getText());
        //read I'm late
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"I'm late"));
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/h3")).getText());
        driver.quit();
    }
}
