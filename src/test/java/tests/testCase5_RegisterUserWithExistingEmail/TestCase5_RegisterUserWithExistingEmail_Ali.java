package tests.testCase5_RegisterUserWithExistingEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;

public class TestCase5_RegisterUserWithExistingEmail_Ali extends TestBaseBeforeClassAfterClass {
    @Test
    public void registerUserWithExistingEmail_test() {
        //Test Case 5: Register User with existing email
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

        //5. Verify 'New User Signup!' is visible
        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        //8. Verify error 'Email Address already exist!' is visible
    }

}
