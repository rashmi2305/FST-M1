package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.openqa.selenium.Keys;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Google Home page$")
    public void HomePage() throws Throwable{
        //In the @Given step,
        //Initialize the driver and wait instance.
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,15);
        //Use get() to open the Google home page
        driver.get("https://www.google.com");
        wait.until(ExpectedConditions.titleIs("Google"));
        Reporter.log("Google Home page is displayed");
    }

    @When("User types in Cheese and hits ENTER$")
    public void EnterValues() throws Throwable{
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Cheese", Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
    }

    @Then("^Show How many results were shown$")
    public void DisplayResults(){
        System.out.println("Results count is: "+driver.findElement(By.id("result-stats")).getText());
    }

    @And("^Close the Browser$")
    public void closeTheBrowser() throws Throwable {
        driver.quit();
    }
}
