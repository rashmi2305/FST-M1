import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Activity8_1 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open the browser with https://training-support.net/selenium/tables using get() method.
        driver.get("https://training-support.net/selenium/tables");
        //Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
        //System.out.println("Number of Columns: " +driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size());        //Output as 6 as gives output for both tables, so need to specify class
        System.out.println("Number of Columns: " +driver.findElements(By.xpath("//table[contains(@class, 'ui celled striped table')]/tbody/tr[1]/td")).size());
        System.out.println("Number of rows: " +driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td")).size());
        //Find and print the all the cell values of the third row of the table.
        List<WebElement> thirdrow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
        for(WebElement rowdata: thirdrow){
            System.out.println("Third row data: "+rowdata.getText());
        }
        //Find and print the cell value at the second row and second column.
        System.out.println("Second Col Second row data: " +driver.findElement(By.xpath("//table[contains(@class, 'ui celled striped table')]/tbody/tr[2]/td[2]")).getText());
        //Close the browser.
        driver.quit();
    }
}
