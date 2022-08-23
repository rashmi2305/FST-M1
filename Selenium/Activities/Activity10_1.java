import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://www.training-support.net/selenium/input-events
        driver.get("https://www.training-support.net/selenium/input-events");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title of the page is: "+driver.getTitle());
        //On the page, perform
        Actions builder = new Actions(driver);
        //Left click and print the value of the side in the front.
        WebElement cube = driver.findElement(By.id("wrapD3Cube"));      ////Find the cude
        builder.click(cube).build().perform();
        //WebElement cubeVal = driver.findElement(By.className("active"));
        System.out.println("Side in front is: "+driver.findElement(By.className("active")).getText());
        //Double click to show a random side and print the number.
        builder.doubleClick().build().perform();
        System.out.println("Side in front is: "+driver.findElement(By.className("active")).getText());
        //Right click and print the value shown on the front of the cube.
        builder.contextClick().build().perform();
        System.out.println("Side in front is: "+driver.findElement(By.className("active")).getText());
        //Finally, close the browser.
        driver.quit();
    }
}
