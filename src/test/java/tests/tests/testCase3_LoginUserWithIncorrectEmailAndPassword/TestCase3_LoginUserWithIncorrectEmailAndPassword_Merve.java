package tests.tests.testCase3_LoginUserWithIncorrectEmailAndPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestCase3_LoginUserWithIncorrectEmailAndPassword_Merve {

    //Test Case 3: Login User with incorrect email and password
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'

    public WebDriver driver;

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

        //6. Enter incorrect email address and password
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("merveozcam@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("123456");

        //7. Click 'login' button
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement errorMessage = driver.findElement(By.tagName("p"));
        System.out.println("errorMessage.isDisplayed() = " + errorMessage.isDisplayed());

    }


}
