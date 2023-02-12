package tests.tests.testCase4_LogoutUser;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import tests.base.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;

public class TestCase4_LogoutUser_Bilal extends TestBaseBeforeClassAfterClass {


    @Test
    public void logoutUser_Test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(driver,"Automation Exercise");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        BrowserUtilities.sleep(2);

        //5. Verify 'Login to your account' is visible
        String loginAccount=driver.findElement(By.xpath("//h2[.='Login to your account']")).getText();
        Assert.assertEquals(loginAccount,"Login to your account");

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(ConfigurationReader.getProperty("email"));
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(ConfigurationReader.getProperty("password"));

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible
        String loggedInVerify= driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[10]/a")).getText();
        Assert.assertEquals(loggedInVerify,"Logged in as "+ ConfigurationReader.getProperty("username"));

        //9. Click 'Logout' button
        driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]")).click();

        //10. Verify that user is navigated to login page
        BrowserUtilities.verifyPageTitle(driver,"Automation Exercise - Signup / Login");


    }
}
