package tests.testCase4_LogoutUser;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
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
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not visible successfully");

        BrowserUtilities.sleep(2);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//li[4]")).click();

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

        //9. Click 'Logout' button

        //10. Verify that user is navigated to login page






        driver.close();


    }
}
