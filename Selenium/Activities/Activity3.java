import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        String title = driver.getTitle();   //Get the title of the page using driver.getTitle() and print out the title.
        //Use findElement() with name() to find the text fields - firstname and lastname.
        WebElement oFirstname = driver.findElement(By.id("firstName"));
        WebElement oLastname = driver.findElement(By.id("lastName"));
        //Use WebElement.sendKeys() to type in those text fields.
        oFirstname.sendKeys("John");
        oLastname.sendKeys("Blake");
        //Similarly, find and type into the email and contact number fields.
        WebElement oEmail = driver.findElement(By.id("email"));
        oEmail.sendKeys("Test@Test.com");
        //Finally, submit the form by clicking the Submit button.
        driver.findElement(By.cssSelector(".ui.green.button")).click();
        Thread.sleep(3000);
        //Close the browser with driver.close()
        driver.quit();
    }
}
