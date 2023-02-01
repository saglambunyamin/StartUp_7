package tests.testCase3_LoginUserWithIncorrectEmailAndPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TestCase3_LoginUserWithIncorrectEmailAndPassword_Benjamin {

    @Test
    public void LoginUserWithIncorrectEmailAndPasswordTest () {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");

        //4. Click on 'Signup / Login' button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//a[.=' Signup / Login']"));
        signUpButton.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountText = Driver.getDriver().findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertEquals(loginToYourAccountText.getText(),"Login to your account");

        //6. Enter incorrect email address and password
        WebElement emailInputBox = Driver.getDriver().findElement(By.xpath("//input[@data-qa='login-email']"));
        emailInputBox.sendKeys("incorrect@email.com");

        WebElement passwordInputBox = Driver.getDriver().findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordInputBox.sendKeys("123456");

        //7. Click 'login' button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement warningMessage = Driver.getDriver().findElement(By.xpath("//p[.='Your email or password is incorrect!']"));
        Assert.assertEquals(warningMessage.getText(), "Your email or password is incorrect!");

    }

}
