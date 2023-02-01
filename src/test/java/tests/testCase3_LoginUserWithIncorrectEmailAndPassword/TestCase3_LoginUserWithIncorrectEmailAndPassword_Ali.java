package tests.testCase3_LoginUserWithIncorrectEmailAndPassword;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TestCase3_LoginUserWithIncorrectEmailAndPassword_Ali extends TestBaseBeforeClassAfterClass {
    @Test
    public void loginUserWithIncorrectEmailAndPassword_test() {
        //Test Case 3: Login User with incorrect email and password
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationexercise.com");

         */
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


        //6. Enter incorrect email address and password
        WebElement incorrectEmailAddress = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        incorrectEmailAddress.sendKeys(ConfigurationReader.getProperty("email"));

        WebElement incorrectPassword = driver.findElement(By.xpath("//input[@name='password']"));
        incorrectPassword.sendKeys("153234");

        //7. Click 'login' button
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement errorMessage = driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']"));
        boolean isVisibleErrorMessage= errorMessage.isDisplayed();
        Assert.assertTrue(isVisibleErrorMessage,"Your email or password is incorrect! is not visible");


    }
}
