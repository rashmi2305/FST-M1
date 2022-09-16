package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.Keys;

public class Alerts_Activity3 {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    String strText;
    @Given("^User is on the page$")
    public void HomePage() throws Throwable{
        driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        //wait.until(ExpectedConditions.titleIs("Javascript Alerts"));
        strText = driver.getTitle();
        System.out.println("Home page title is: "+strText);
        //Assert.assertEquals("", strText);
    }

    @When("^User clicks on Simple Alert$")
    public void SimpleAlertClick() throws Throwable{
        driver.findElement(By.cssSelector("#simple")).click();
    }

    @When("^User clicks on Confirm Alert$")
    public void ConfirmAlertClick() throws Throwable{
        driver.findElement(By.cssSelector("#confirm")).click();
    }

    @When("^User clicks on Prompt Alert$")
    public void PromptAlertClick() throws Throwable{
        driver.findElement(By.cssSelector("#prompt")).click();
    }

    @Then("^Read Alert Text$")
    public void ReadAlert() throws Throwable{
        alert = driver.switchTo().alert();
        strText = alert.getText();
        System.out.println("Alert  Text is: "+strText);
        //Assert.assertEquals("", strText);
    }

    @Then("^Enter Value in prompt popup$")
    public void AlertText(){
        alert = driver.switchTo().alert();
        alert.sendKeys("Prompt alert text Message");
        strText = alert.getText();
        System.out.println("Alert  Text is: "+strText);
        //Assert.assertEquals("", strText);
    }

    @And("^Accept Alert$")
    public void AcceptAlert(){
        alert.accept();
    }

    @And("^Close browser$")
    public void closeBrowser() throws Throwable {
        driver.quit();
    }
}
