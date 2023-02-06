package tests.tests.testCase3_LoginUserWithIncorrectEmailAndPassword;
/*Test Case 3: Login User with incorrect email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;

public class TestCase3_LoginUserWithIncorrectEmailAndPassword_Mustafa extends TestBaseBeforeClassAfterClass {
    @Test
    public void loginUserWithIncorrectEmailAndPassword() {
        driver.get(ConfigurationReader.getProperty("env"));

        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(driver.getTitle(),expectedTitle,"Home page is not visible successfully.");

        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

        WebElement loginToYourAccount= driver.findElement(By.cssSelector("div.login-form>h2"));
        boolean loginToYourAccountIsVisible=loginToYourAccount.isDisplayed();
        Assert.assertTrue(loginToYourAccountIsVisible,"Login to your account is not visible");

        WebElement emailAddress= driver.findElement(By.cssSelector("input:nth-child(2)"));
        emailAddress.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement password= driver.findElement(By.cssSelector("input:nth-child(3)[name='password']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginButton=driver.findElement(By.xpath("//button[.='Login']"));
        loginButton.submit();

        WebElement errorMessage=driver.findElement(By.xpath("//*[contains(text(),'incorrect')]"));
        String expectedErrorMessage="Your email or password is incorrect!";
        Assert.assertEquals(errorMessage.getText(),expectedErrorMessage,"Your email or password is incorrect! is not visible");

    }
}
