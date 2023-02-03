package tests.testCase5_RegisterUserWithExistingEmail;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import testBase.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;

public class TestCase5_RegisterUserWithExistingEmail_Bilal extends TestBaseBeforeClassAfterClass {


    @Test
    public void test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(driver,"Automation Exercise");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        BrowserUtilities.sleep(2);

        //5. Verify 'New User Signup!' is visible
        String actualNewUserSingUp=driver.findElement(By.xpath("//h2[.='New User Signup!']")).getText();
        Assert.assertEquals(actualNewUserSingUp, "New User Signup!");

        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(ConfigurationReader.getProperty("email"));

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        BrowserUtilities.sleep(2);


        //8. Verify error 'Email Address already exist!' is visible
        String actualEmailExistMessage= driver.findElement(By.xpath("//b[.='Email Address already exist!']")).getText();
        Assert.assertEquals(actualEmailExistMessage,"Email Address already exist!");






    }
}
