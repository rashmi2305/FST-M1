import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Activity8_2 {
    public static void main(String[] args){
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open the browser with https://training-support.net/selenium/tables using get() method.
        driver.get("https://training-support.net/selenium/tables");
        //Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
        //System.out.println("Number of Columns: " +driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size());        //Output as 6 as gives output for both tables, so need to specify class
        System.out.println("Number of Columns: " +driver.findElements(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[1]/td")).size());
        System.out.println("Number of rows: " +driver.findElements(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[1]/td")).size());
        //Find and print the cell value at the second row and second column for sortable table
        System.out.println("Second Col Second row data: " +driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]")).getText());
        //Click the header of the first column to sort by name.
        driver.findElement(By.xpath("//table[contains(@class,'sortable')]/thead/tr/th[1]")).click();
        //Find and print the cell value at the second row and second column again.
        System.out.println("Second Col Second row data after sorting: " +driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]")).getText());
        //Print the cell values of the table footer.
        List<WebElement> footerdata = driver.findElements(By.xpath("//table[contains(@class,'sortable')]/tfoot/tr"));
        for(WebElement data: footerdata){
            System.out.println("Footer data: "+data.getText());
        }
        //Close the browser.
        driver.quit();
    }
}
