package CRM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

interface LoginApplication{
    public void LaunchApp(String URL);
    //void QuitApp();               //Understand y it can't be done here
    public String Readtitle();
}

class LoginApp implements LoginApplication{
    public String URL;
    public String XPathValue;
    public String tbValue;
    public int iRowNum;
    List<WebElement> colList;
    WebDriver d = new FirefoxDriver();
    public void LaunchApp(String URL){
        this.URL = URL;
        System.out.println(URL);
        d.get(URL);
        d.manage().window().maximize();
        d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
    void QuitApp(){
        d.quit();
    }

    public String Readtitle(){
        return(d.getTitle());
    }
    public String ReadElementText(String XPathValue){
        this.XPathValue = XPathValue;
        return(d.findElement(By.xpath(XPathValue)).getText());
    }
    public String ReadScanText(String XPathValue){
        this.XPathValue = XPathValue;
        return(d.findElement(By.xpath(XPathValue)).getText());
    }
    public void EnterTextBoxValue(String XPathValue, String tbValue){
        this.XPathValue = XPathValue;
        this.tbValue = tbValue;
        d.findElement(By.xpath(XPathValue)).sendKeys(tbValue);
    }
    public void ClickButton(String XPathValue){
        this.XPathValue = XPathValue;
        d.findElement(By.xpath(XPathValue)).click();
    }

    public String FindColor(String XPathValue){
        this.XPathValue = XPathValue;
        return(d.findElement(By.xpath(XPathValue)).getCssValue("color"));
    }
    public boolean ElementExists(String XPathValue){
        this.XPathValue = XPathValue;
        return(d.findElement(By.xpath(XPathValue)).isDisplayed());
    }
    public String WebTableRowData(int iRowNum){
        this.iRowNum = iRowNum;
        //return(d.findElement(By.xpath("//table/tbody/tr["+iRowNum+"]")).getText());
        return(d.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr["+iRowNum+"]/td[3]/b/a")).getText());
    }
    public void WebTableColData(String XPathValue){
        this.XPathValue = XPathValue;
        List<WebElement> colList = d.findElements(By.className(XPathValue));
        for(WebElement column: colList){
            System.out.println(column.getText());
        }
    }
}

public class CRMProject{
    public static void main(String[] args) throws InterruptedException{
        String title;
        //LoginApp la = new LoginApp();
        String URL = "https://alchemy.hguy.co/crm/";
        /*
        //Task1: Read the title of the website and verify the text
        la.LaunchApp(URL);
        System.out.println("Verifying the page title has started");
        System.out.println("Title of the page is: " + la.Readtitle());
        Assert.assertEquals("SuiteCRM",la.Readtitle(),"Page title doesn't match");
        la.QuitApp();

        //Task2: Print the url of the header image to the console
        LoginApp la1 = new LoginApp();
        la1.LaunchApp(URL);
        System.out.println("URL of the header image to the console: " + la1.Readtitle());
        la1.QuitApp();

        //Task3: Print the first copyright text in the footer to the console
        LoginApp la3 = new LoginApp();
        la3.LaunchApp(URL);
        System.out.println("Copyright of the page is: "+ la3.ReadElementText("//*[@id=\"admin_options\"]"));
        la3.QuitApp();

        //Task4:Open the site and login with the credentials provided
        LoginApp la4 = new LoginApp();
        la4.LaunchApp(URL);
        la4.EnterTextBoxValue("//*[@id=\"user_name\"]","admin");
        la4.EnterTextBoxValue("//*[@id=\"username_password\"]","pa$$w0rd");
        la4.ClickButton("//*[@id=\"bigbutton\"]");
        System.out.println("Title of the page is: " + la4.Readtitle());
        Assert.assertEquals("SuiteCRM",la4.Readtitle(),"Page title doesn't match");
        la4.QuitApp();

        //Task5:Get the color of the navigation menu
        LoginApp la5 = new LoginApp();
        la5.LaunchApp(URL);
        la5.EnterTextBoxValue("//*[@id=\"user_name\"]","admin");
        la5.EnterTextBoxValue("//*[@id=\"username_password\"]","pa$$w0rd");
        la5.ClickButton("//*[@id=\"bigbutton\"]");
        System.out.println("Color of navigation bar is: " + la5.FindColor("//*[@id=\"toolbar\"]"));
        la5.QuitApp();

        //Task6:Make sure that the “Activities” menu item exists and is clickable
        LoginApp la6 = new LoginApp();
        la6.LaunchApp(URL);
        la6.EnterTextBoxValue("//*[@id=\"user_name\"]","admin");
        la6.EnterTextBoxValue("//*[@id=\"username_password\"]","pa$$w0rd");
        la6.ClickButton("//*[@id=\"bigbutton\"]");
        if(la6.ElementExists("//*[@id=\"toolbar\"]")){
            if(la6.ElementExists("//*[@id=\"grouptab_3\"]")){
                System.out.println("Activities button exists");
            }else{
                System.out.println("Activities button doesn't exists");
            }
        }else{
            System.out.println("Navigation bar doesn't exists");
        }

        //Task7: Reading a popup that contains additional information about the account/lead.
        LoginApp la7 = new LoginApp();
        la7.LaunchApp(URL);
        la7.EnterTextBoxValue("//*[@id=\"user_name\"]","admin");
        la7.EnterTextBoxValue("//*[@id=\"username_password\"]","pa$$w0rd");
        la7.ClickButton("//*[@id=\"bigbutton\"]");
        la7.ClickButton("//*[@id=\"grouptab_0\"]");
        la7.ClickButton("//*[@id=\"moduleTab_9_Leads\"]");
        //la6.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        la7.ClickButton("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[10]/span/span");
        System.out.println("Phone Number displayed is " + la7.ReadScanText("//button[@data-target='#myModal']"));

        //Task8: Open the accounts page and print the contents of the table
        LoginApp la8 = new LoginApp();
        la8.LaunchApp(URL);
        la8.EnterTextBoxValue("//*[@id=\"user_name\"]","admin");
        la8.EnterTextBoxValue("//*[@id=\"username_password\"]","pa$$w0rd");
        la8.ClickButton("//*[@id=\"bigbutton\"]");
        la8.ClickButton("//*[@id=\"grouptab_0\"]");
        la8.ClickButton("//*[@id=\"moduleTab_9_Accounts\"]");
        //la6.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        //Find the table on the page and print the names of the first 5 odd-numbered rows
        //of the table to the console.
        System.out.println("First Row Data: "+la8.WebTableRowData(1));
        System.out.println("Third Row Data: "+la8.WebTableRowData(3));
        System.out.println("Fifth Row Data: "+la8.WebTableRowData(5));
        System.out.println("Seventh Row Data: "+la8.WebTableRowData(7));
        System.out.println("Ninth Row Data: "+la8.WebTableRowData(9));
        la8.QuitApp();
        */
        //Task9: Open the leads page and print the usernames and full names from the table.
        LoginApp la9 = new LoginApp();
        la9.LaunchApp(URL);
        la9.EnterTextBoxValue("//*[@id=\"user_name\"]","admin");
        la9.EnterTextBoxValue("//*[@id=\"username_password\"]","pa$$w0rd");
        la9.ClickButton("//*[@id=\"bigbutton\"]");
        la9.ClickButton("//*[@id=\"grouptab_0\"]");
        la9.ClickButton("//*[@id=\"moduleTab_9_Leads\"]");
        //la6.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        la9.WebTableColData("inlineEdit");
    }
}
