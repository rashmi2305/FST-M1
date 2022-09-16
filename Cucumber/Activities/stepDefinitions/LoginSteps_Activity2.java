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

public class LoginSteps_Activity2 {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Testing Login page$")
    public void LoginPage() throws Throwable{
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("https://www.training-support.net/selenium/login-form");
        wait.until(ExpectedConditions.titleIs("Login Form"));
    }

    @When("^User enters username and password$")
    public void EnterLoginCredentials() throws Throwable{
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("action-confirmation"))));
    }

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void EnterLoginCredentials_Parameters(String username, String password) throws Throwable{
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("action-confirmation"))));
    }

    @Then("^Read the page title and show the confirmation message$")
    public void DisplayConfirmation() throws Throwable{
        System.out.println("Page title after login is: "+driver.findElement(By.id("action-confirmation")).getText());
    }

    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.quit();
    }
}
