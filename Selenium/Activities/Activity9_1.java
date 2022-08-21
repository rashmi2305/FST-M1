import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Activity9_1 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open the browser with https://training-support.net/selenium/selects using the get() method.
        driver.get("https://training-support.net/selenium/selects");
        //Use findElement() to find the dropdown WebElement on the page.
            //WebElement dropdown = driver.findElement(By.tagName("//select"));
        //Create a new Select class object with the WebElement.
            //Select select = new Select(dropdown);
        WebElement chosen = driver.findElement(By.id("single-value"));
        Select dropdown = new Select(driver.findElement(By.id("single-select")));
        //On the dropdown,
        //Select the second option using selectByVisibleText()
        dropdown.selectByVisibleText("Option 2");
        //Select the third option using selectByIndex()
        dropdown.selectByIndex(3);
        //Select the fourth option using selectByValue()
        dropdown.selectByValue("4");
        //Finally, get all the options in the dropdown and print them one by one.
        List<WebElement> options = dropdown.getOptions();
        for(WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }
    }
}
