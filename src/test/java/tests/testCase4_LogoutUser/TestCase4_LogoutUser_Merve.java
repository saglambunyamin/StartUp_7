package tests.testCase4_LogoutUser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static testBase.TestBaseBeforeClassAfterClass.driver;

public class TestCase4_LogoutUser_Merve {
    /*Test Case 4: Logout User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
 public WebDriver driver;*/

    @BeforeMethod
    public void setupMethod() {
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationexercise.com");

    }

    @Test
    public void loginUser() {
        //3. Verify that home page is visible successfully
        String actualHomePage = driver.getTitle();
        String expectedHomePage = "Automation Exercise";
        System.out.println("actualHomePage = " + actualHomePage);
        Assert.assertEquals(actualHomePage, expectedHomePage);

        //4. Click on 'Signup / Login' button
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signInButton.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginTitleVisible = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        System.out.println("loginTitleVisible.isDisplayed() = " + loginTitleVisible.isDisplayed());

        //6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("mervemerve@hotmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("987654");
       //7. Click 'login' button
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();
        //8. Verify that 'Logged in as username' is visible
        WebElement loggedMessage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        System.out.println("loggedMessage.isDisplayed() = " + loggedMessage.isDisplayed());

        //9. Click 'Logout' button
        WebElement logOutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
        logOutButton.click();

        //10. Verify that user is navigated to login page
        String verifyLoginPage = driver.getTitle();
        System.out.println("verifyLoginPage = " + verifyLoginPage);
        Assert.assertEquals(verifyLoginPage, "Automation Exercise - Signup / Login");

    }
}








