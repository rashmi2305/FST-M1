import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open a browser with https://www.training-support.net/selenium/javascript-alerts
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title: " + driver.getTitle());
        //Use findElement() to find the button to open a PROMPT alert and click it.
        driver.findElement(By.id("prompt")).click();
        //Switch the focus from the main window to the Alert box and Use sendKeys() to type in "Yes, you are!".
        wait.until((ExpectedConditions.alertIsPresent()));
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Yes, you are!");
        //Close the alert once with alert.accept()
        Thread.sleep(3000);
        alert.accept();
        driver.quit();
    }
}
