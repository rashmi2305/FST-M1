import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser with https://training-support.net/selenium/dynamic-attributes
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title: "+driver.getTitle());
        driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("TestUser");
        driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("TestPassword");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[3]/input")).sendKeys("TestPassword");
        driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input")).sendKeys("Test@test.com");
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
        System.out.println("Login message: " + driver.findElement(By.id("action-confirmation")).getText());
        driver.quit();
    }
}
