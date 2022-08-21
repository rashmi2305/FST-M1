import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    //Create a Class and a main() method
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://www.training-support.net/selenium/simple-form
        driver.get("https://www.training-support.net/selenium/simple-form");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title of page is: " + driver.getTitle());
        //Use findElement() with xpath() to find all the input fields on the page.
        //Fill in the details in the fields using the sendKeys() method.
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("John");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Doe");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Test@Test.com");
        driver.findElement(By.xpath("//*[@id=\"number\"]")).sendKeys("9999999999");
        //Click the submit button at the end of the form to submit the form.
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[1]/input")).click();
    }
}
