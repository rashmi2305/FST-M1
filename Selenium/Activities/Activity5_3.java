import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    //Create a Package with a Class and a main() method
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the page title and print it to the console.
        System.out.println("Title of the page is: "+driver.getTitle());
        //Use findElement() to find the text field
        WebElement cbElement = driver.findElement(By.xpath("//*[@id=\"dynamicText\"]"));
        //Use the isEnabled() method to check if the text field is enabled.
        System.out.println("Text field display status is: "+cbElement.isEnabled());
        //Click the "Enable Input" button to enable the input field.
        driver.findElement(By.id("toggleInput")).click();
        //Use the isEnabled() method again and print the result.
        System.out.println("Text field display status after clicking on button: "+cbElement.isEnabled());
        driver.quit();
    }
}
