package tests.testCase3_LoginUserWithIncorrectEmailAndPassword;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestCase3_LoginUserWithIncorrectEmailAndPassword_Emin {
    WebDriver driver;
    @BeforeMethod
        public void setupMethod() {
        //1. Launch browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
        public void login_User_With_Incorrect_Details(){
        //2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle= "Automation Exercise";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not visible successfully");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginAccount= driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertTrue(loginAccount.isDisplayed(),"Login to your account is not visible");

        //6. Enter incorrect email address and password
        Faker faker = new Faker();
        WebElement emailData= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        String incorrectEmail = faker.internet().emailAddress();
        emailData.sendKeys(incorrectEmail);

        BrowserUtilities.sleep(2);

        WebElement passwordData= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        String incorrectPassword= faker.numerify("#############");
        passwordData.sendKeys(incorrectPassword);

        BrowserUtilities.sleep(2);

        //7. Click 'login' button
        WebElement loginButton= driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement verifyIncorrectText= driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']"));
        Assert.assertTrue(verifyIncorrectText.isDisplayed(),"Error message is not visible");
        }

        @AfterMethod
       public void closingMethod(){
        driver.close();
        }

    }

