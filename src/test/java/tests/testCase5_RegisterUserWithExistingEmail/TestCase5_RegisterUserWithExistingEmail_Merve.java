package tests.testCase5_RegisterUserWithExistingEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TestCase5_RegisterUserWithExistingEmail_Merve {
    /*Test Case 5: Register User with existing email
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible*/

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void RegisterUser () throws InterruptedException {
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");
       // 4. Click on 'Signup / Login' button
        WebElement signUpLoginButton = Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
        signUpLoginButton.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserVerify = Driver.getDriver().findElement(By.xpath("//h2[.='New User Signup!']"));
        System.out.println("newUserVerify.isDisplayed() = " + newUserVerify.isDisplayed());
        Thread.sleep(2000);
        //6. Enter name and already registered email address
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-name']"));
        userName.sendKeys("mervemerve");

        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("mervemerve@hotmail.com");

        Thread.sleep(2000);
        //7. Click 'Signup' button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpButton.click();
        //8. Verify error 'Email Address already exist!' is visible
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//p[.='Email Address already exist!']"));
        System.out.println("errorMessage.isDisplayed() = " + errorMessage.isDisplayed());


    }
}
