package tests.testCase2_LoginUserWithCorrectEmailAndPassword;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TestCase2_LoginUser_Merve {
    public static void main(String[] args) {
//Test Case 2: Login User with correct email and password
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationexercise.com");
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
        email.sendKeys("merveozcam@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("123456");
//7. Click 'login' button
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();
//8. Verify that 'Logged in as username' is visible
        WebElement usernameVerification = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        System.out.println("usernameVerification.isDisplayed() = " + usernameVerification.isDisplayed());
//9. Click 'Delete Account' button
        WebElement deleteAccountButton = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccountButton.click();
//10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDeletedMessage = driver.findElement(By.xpath("//h2//b"));
        System.out.println("accountDeletedMessage.isDisplayed() = " + accountDeletedMessage.isDisplayed());

    }
}
