import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();             //Create a WebDriver instance, named driver, with the FirefoxDriver().
        String URL = "https://www.training-support.net";    //Open a browser with https://www.training-support.net
        driver.get(URL);
        String title = driver.getTitle();
        System.out.println("Title of the page is: "+ title);
        WebElement oIdElement = driver.findElement(By.id("about-link"));
        System.out.println("Text in element: " + oIdElement.getText());
        WebElement oCNElement = driver.findElement(By.className("green"));
        System.out.println("Text in element using class name: " + oCNElement.getText());
        WebElement oLTElement = driver.findElement(By.linkText("About Us"));
        System.out.println("Text in element: using Link Test " + oLTElement.getText());
        WebElement oCSSElement = driver.findElement(By.cssSelector(".green"));
        System.out.println("Text in element using cs selector: " + oCSSElement.getText());
        driver.quit();
    }
}
