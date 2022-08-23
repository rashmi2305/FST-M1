import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

import java.time.Duration;

public class Activity11_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open a browser with https://www.training-support.net/selenium/tab-opener
        driver.get("https://www.training-support.net/selenium/tab-opener");
        //Print the Page Title and Handle of that tab.
        System.out.println("Title of page is: " + driver.getTitle());
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Window: " + parentHandle);
        //Find the button to open a new tab and click it.
        driver.findElement(By.id("launcher")).click();
        //Wait for the new tab to open.
        Thread.sleep(3000);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //Print all the handles.
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All window handles: " + allHandles);
        //Switch to the newly opened tab, print it's title and heading.

        //loop thru to switch the windows and select newest tab
        for(String handle : allHandles) {
                driver.switchTo().window(handle);
        }
        //wait.until(ExpectedConditions.titleIs("NewTab"));
        //Print New Tab Title
        Thread.sleep(3000);
        System.out.println("New Tab Title is: " + driver.getTitle());
        //Repeat steps 6-8 by clicking the button on the new tab.
        driver.findElement(By.linkText("Open Another One!")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        //Add third tab title to allHandles
        allHandles = driver.getWindowHandles();
        System.out.println("All window handles: " + allHandles);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.titleIs("Newtab2"));
        System.out.println("New Tab Title is: " + driver.getTitle());
        //Finally, close both windows using quit().
        //System.out.println("New tab heading is: " + driver.findElement(By.cssSelector("div.content")).getText());
        driver.quit();
    }
}
