package tests.tests.testCase4_LogoutUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestCase4_LogoutUser_Emin {

    WebDriver driver;

    @Test
    public void logoutUser_Test(){

        //1. Launch browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle= "Automation Exercise";
        String actualTitle= Driver.getDriver().getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is visible successfully");
        }else{
            System.out.println("\"Title is not visible successfully\"");
        }

        BrowserUtilities.sleep(2);

        //4. Click on 'Signup / Login' button
        WebElement signupButton= driver.findElement(By.xpath("//li[4]"));
        signupButton.click();

        //5. Verify 'Login to your account' is visible
       WebElement loginAccount= driver.findElement(By.xpath("//h2[.='Login to your account']"));
       Assert.assertTrue(loginAccount.isDisplayed(),"Login to your account is not visible");

        //6. Enter correct email address and password
        WebElement correctEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        correctEmail.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement correctPassword = driver.findElement(By.xpath("//input[@name='password']"));
        correctPassword.sendKeys(ConfigurationReader.getProperty("password"));

        BrowserUtilities.sleep(2);

        //7. Click 'login' button
        WebElement loginButton= driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedMessage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        System.out.println("loggedMessage.isDisplayed() = " + loggedMessage.isDisplayed());

        //9. Click 'Logout' button
        WebElement logOutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
        logOutButton.click();

        //10. Verify that user is navigated to login page
        String verifyLoginPage = driver.getTitle();
        System.out.println("verifyLoginPage = " + verifyLoginPage);
        Assert.assertEquals(verifyLoginPage, "Automation Exercise - Signup / Login");

        driver.close();

    }
}
