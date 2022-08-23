import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://www.training-support.net/selenium/input-events
        driver.get("https://www.training-support.net/selenium/input-events");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title of the page is: " + driver.getTitle());
        Actions builder = new Actions(driver);
        //Press the key of your first name in caps
        WebElement keypressed = driver.findElement(By.id("keyPressed"));
        System.out.println("Pressed key is: " + keypressed.getText());
        Action actionsToPerform1 = builder.sendKeys("R").build();
        actionsToPerform1.perform();
        System.out.println("Pressed key is: " + keypressed.getText());
        //Press CTRL+a and the CTRL+c to copy all the text on the page.
        Action actionsToPerform2 = builder.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build();
        actionsToPerform2.perform();
        //(Paste the text in a text editor to verify results.)
        System.out.println("Pressed key text is: " + keypressed.getText());
        driver.quit();
    }
}
