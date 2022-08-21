import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Activity7_1 {
    //Create a Class and a main() method
    public static void main(String[] args) throws InterruptedException {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open a browser with https://training-support.net/selenium/dynamic-attributes
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title: "+driver.getTitle());
        //Find the username and password input fields. Type in the credentials:
        //username: admin
        //password: password
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[1]/input")).sendKeys("admin");
        //driver.findElement(By.xpath("//input[starts-with(@class, 'username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class, 'password')]")).sendKeys("password");
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        //Wait for login message to appear and print the login message to the console.
        System.out.println("Login message: " + driver.findElement(By.id("action-confirmation")).getText());
        //Finally, close the browser.
        driver.quit();
    }

}
