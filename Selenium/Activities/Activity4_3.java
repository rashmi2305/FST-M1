import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    //Create a Class and a main() method
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://www.training-support.net/selenium/target-practice
        driver.get("https://www.training-support.net/selenium/target-practice");
        //Get the title of the page using driver.getTitle() and print out the title.
        System.out.println("Title of page is: " + driver.getTitle());
        //Use findElement() with xpath() to
        //Find the third header on the page.
        System.out.println("Third header on page is: " + driver.findElement(By.className("yellow")).getText());
        //Find the fifth header on the page and get it's 'colour' CSS Property.
        System.out.println("Fifth header on page color is: " + driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5")).getCssValue("color"));
        //Find the violet button on the page and print all the class attribute values.
        System.out.println("Violet button class attribute values: " + driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class"));
        //Find the grey button on the page with Absolute XPath.
        System.out.println("grey button on the page is: " + driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText());
    }
}
