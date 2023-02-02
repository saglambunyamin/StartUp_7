package tests.testCase3_LoginUserWithIncorrectEmailAndPassword;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import testBase.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;

public class TestCase3_LoginUserWithIncorrectEmailandPassword_Bilal extends TestBaseBeforeClassAfterClass {

    @Test
    public void incorrectEmailandPassword_Test(){

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

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(faker.internet().password());

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        String errorMessage=driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).getText();
        Assert.assertEquals(errorMessage,"Your email or password is incorrect!");

    }
}
