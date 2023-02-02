package tests.testCase4_LogoutUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase4_LogoutUser_Ali extends TestBaseBeforeClassAfterClass {
    @Test
    public void logoutUser_test(){
        //Test Case 4: Logout User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Home page is not visible");

        //4. Click on 'Signup / Login' button
        WebElement signupLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[.='Login to your account']"));
        boolean isVisibleLoginToYourAccount=loginToYourAccount.isDisplayed();
        Assert.assertTrue(isVisibleLoginToYourAccount,"Login to your account is not visible");


        //6. Enter correct email address and password
        WebElement correctEmailAddress = Driver.getDriver().findElement(By.xpath("//input[@data-qa='login-email']"));
        correctEmailAddress.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement correctPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        correctPassword.sendKeys(ConfigurationReader.getProperty("password"));


    }
}
