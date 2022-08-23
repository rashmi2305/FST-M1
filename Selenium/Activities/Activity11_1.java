import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open a browser with https://www.training-support.net/selenium/javascript-alerts
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title: "+driver.getTitle());
        //Use findElement() to find the button to open a SIMPLE alert and click it.
        driver.findElement(By.id("simple")).click();
        //Switch the focus from the main window to the Alert box and get the text in it and print it.
        wait.until((ExpectedConditions.alertIsPresent()));
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple Alert text message is: "+alert.getText());
        //Finally, close the alert with alert.accept() and close() the browser
        alert.accept();
        driver.quit();
    }
}
