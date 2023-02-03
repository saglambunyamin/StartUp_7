package tests.testCase5_RegisterUserWithExistingEmail;

import com.github.javafaker.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase5_RegisterUserWithExistingEmail_Ali {
    @Test
    public void registerUserWithExistingEmail_test() {
        //Test Case 5: Register User with existing email
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));


        //3. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Home page is not visible");

        //4. Click on 'Signup / Login' button
        WebElement signupLoginButton = Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup = Driver.getDriver().findElement(By.xpath("//h2[.='New User Signup!']"));
        if (newUserSignup.isDisplayed()) {
            System.out.println(newUserSignup.getText()+" is visible");
        } else {
            System.out.println("New User Signup! is not visible");
        }
        //6. Enter name and already registered email address
        WebElement nameBox = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        nameBox.sendKeys("ali.karanlik");

        WebElement emailAddressBox = Driver.getDriver().findElement(By.xpath("(//input[@type='email'])[2]"));
        emailAddressBox.sendKeys(ConfigurationReader.getProperty("username"));

        //7. Click 'Signup' button
        WebElement signupButton = Driver.getDriver().findElement(By.xpath("//button[.='Signup']"));
        signupButton.click();

        //8. Verify error 'Email Address already exist!' is visible
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]"));
        if (errorMessage.isDisplayed()){
            System.out.println(errorMessage.getText() + " is visible");
        }else {
            System.out.println("Email Address already exist! is not visible");
        }

    }

}
