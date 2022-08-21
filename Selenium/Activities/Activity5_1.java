import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    //Create a Package with a Class and a main() method
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the page title and print it to the console.
        System.out.println("Title of the page is: "+driver.getTitle());
        //Use findElement() to find the checkbox input element.
        WebElement cbElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input"));
        //Use the isDisplayed() method to check if it is visible on the page.
        System.out.println("Checkbox display status is: "+cbElement.isDisplayed());
        //Click the "Remove Checkbox".
        driver.findElement(By.id("toggleCheckbox")).click();
        //Print the result of the isDisplayed() method again.
        System.out.println("Checkbox display status after clicking on remove is: "+cbElement.isDisplayed());
        driver.quit();
    }
}
