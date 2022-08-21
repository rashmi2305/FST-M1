import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args){
        //Create a Class and a main() method
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open the browser with https://training-support.net/selenium/selects using the get() method.
        driver.get("https://training-support.net/selenium/selects");
        //Use findElement() to find the multi-select WebElement on the page.
        WebElement chosen = driver.findElement(By.id("multi-value"));
        //Create a new Select class object with the WebElement.
        Select multiselect = new Select(driver.findElement(By.id("multi-select")));
        //Check if the HTML element is a multi-list. Proceed with other actions if it is.
        if(multiselect.isMultiple()){
            //Select the 'JavaScript' option by visible text.
            multiselect.selectByVisibleText("Javascript");
            //Select the 'NodeJS' option by value.
            multiselect.selectByValue("node");
            //Select the 4th, 5th, and the 6th options by index.
            multiselect.selectByIndex(4);
            multiselect.selectByIndex(5);
            multiselect.selectByIndex(6);
            //Deselect the 'NodeJS' option by value attribute.
            multiselect.deselectByValue("node");
            //Deselect the 7th option by index.
            multiselect.deselectByIndex(7);
            //Print the first selected option.
            System.out.println("First Selected option: " + multiselect.getFirstSelectedOption());
            //Print all selected options one by one and deselect all options.
            List<WebElement> allSelected = multiselect.getAllSelectedOptions();
            for(WebElement selected: allSelected){
                System.out.println("Selected option: " + selected.getText());
            }
            multiselect.deselectAll();
        }
    }
}
