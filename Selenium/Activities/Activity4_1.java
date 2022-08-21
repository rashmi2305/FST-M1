import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    //Create a Class and a main() method
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://www.training-support.net
        driver.get("https://www.training-support.net");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title of page is: " + driver.getTitle());
        //Use findElement() with xpath() to find and click the "About Us" link on the page.
        WebElement oLink = driver.findElement(By.xpath("//*[@id=\"about-link\"]"));
        oLink.click();
        //Print the title of the new page that open when the link is clicked.
        System.out.println("Title of the new page is: " + driver.getTitle());
    }
}
