import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_3 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open a browser with https://training-support.net/selenium/drag-drop
        driver.get("https://training-support.net/selenium/drag-drop");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title of the page is: " + driver.getTitle());

        Actions builder = new Actions(driver);
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        //Find the ball and simulate a click and drag to move it into "Dropzone 1".
        Action action1 = builder.dragAndDrop(ball, dropzone1).build();
        action1.perform();
        //Verify that the ball has entered Dropzone 1.
        if(dropzone1.getCssValue("background-color") == "rgb(33, 186, 69)"){
            System.out.println("Ball dropped in dropzone 1");
        }
        //Once verified, move the ball into "Dropzone 2".
        Action action2 = builder.dragAndDrop(dropzone1,dropzone2).build();
        action2.perform();
        //Verify that the ball has entered Dropzone 2.
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone2,"background-color"));
        System.out.println("Ball dropped in dropzone 2");
        //Once verified, close the browser.
        driver.quit();
    }
}
