package tests.tests.testCase2_LoginUserWithCorrectEmailAndPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import tests.base.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;
import utilities.Driver;

public class testCase2_LoginUserWithCorrectEmailAndPassword_Ali extends TestBaseBeforeClassAfterClass {
    @Test
    public  void loginUserWithCorrectEmailAndPassword_test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();
        //Assert.assertEquals(actualTitle,expectedTitle);
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Home page is visible");
        }else{
            System.out.println("Home page is not visible");
        }
        //4. Click on 'Signup / Login' button
        WebElement signupLoginButton = Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton.click();
        BrowserUtilities.sleep(1);

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountTxt = Driver.getDriver().findElement(By.xpath("//h2[.='Login to your account']"));
        if(loginToYourAccountTxt.isDisplayed()){
            System.out.println("Login to your account is visible");
        }else {
            System.out.println("Login to your account is not visible");
        }

        //6. Enter correct email address and password

        WebElement correctEmailAddress = Driver.getDriver().findElement(By.xpath("//input[@data-qa='login-email']"));
        correctEmailAddress.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement correctPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        correctPassword.sendKeys(ConfigurationReader.getProperty("password"));

        //7. Click 'login' button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible
    }
}
