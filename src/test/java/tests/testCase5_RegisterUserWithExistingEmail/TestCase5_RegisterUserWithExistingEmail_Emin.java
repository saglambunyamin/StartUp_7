package tests.testCase5_RegisterUserWithExistingEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.WebDriverFactory;

public class TestCase5_RegisterUserWithExistingEmail_Emin {

@Test
   public void registerUser() {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    Driver.getDriver().get("http://automationexercise.com");

//3. Verify that home page is visible successfully
    String expectedTitle= "Automation Exercise";
    String actualTitle= Driver.getDriver().getTitle();
    Assert.assertEquals(actualTitle,expectedTitle,"Home page is not visible");

//4. Click on 'Signup / Login' button
    WebElement signupButton= Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
    signupButton.click();

//5. Verify 'New User Signup!' is visible
    WebElement newUserSignup= Driver.getDriver().findElement(By.xpath("//h2[.='New User Signup!']"));
    System.out.println("newUserSignup.isDisplayed() = " + newUserSignup.isDisplayed());

//6. Enter name and already registered email address
    WebElement name= Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-name']"));
    name.sendKeys(ConfigurationReader.getProperty("username"));

    WebElement email= Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-email']"));
    email.sendKeys(ConfigurationReader.getProperty("email"));

 BrowserUtilities.sleep(2);

//7. Click 'Signup' button
    WebElement signUpButton= Driver.getDriver().findElement(By.xpath("//button[@data-qa='signup-button']"));
    signUpButton.click();

//8. Verify error 'Email Address already exist!' is visible
    WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//p[.='Email Address already exist!']"));
    System.out.println("errorMessage.isDisplayed() = " + errorMessage.isDisplayed());


}

}
