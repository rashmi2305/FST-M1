import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6_1 {
    //Create a Package with a Class and a main() method
    public static void main(String[] args) throws InterruptedException{
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the page title and print it to the console.
        System.out.println("Title of the page is: "+driver.getTitle());
        //Find the checkbox toggle button and click it.
        WebElement cbElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input"));
        //Wait till the checkbox disappears.
        if(cbElement.isDisplayed()){
            driver.findElement(By.id("toggleCheckbox")).click();
        }
        //Click the button again. Wait till it appears and check the checkbox.
        driver.findElement(By.id("toggleCheckbox")).click();
        Thread.sleep(3000);
        if(cbElement.isDisplayed()){
            System.out.println("check box is displayed again");
        }
        //Finally, close the browser.
        driver.quit();
    }
}
