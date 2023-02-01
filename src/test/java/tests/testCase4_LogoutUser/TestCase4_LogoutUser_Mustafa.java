package tests.testCase4_LogoutUser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utilities.ConfigurationReader;

import java.util.concurrent.TimeUnit;

/*Test Case 4: Logout User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page*/
public class TestCase4_LogoutUser_Mustafa {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://automationexercise.com");

        Assert.assertEquals(driver.getTitle(),"Automation Exercise","Home page is not visible successfully.");

        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

        WebElement loginToYourAccount= driver.findElement(By.cssSelector("div.login-form>h2"));
        boolean loginToYourAccountIsVisible=loginToYourAccount.isDisplayed();
        Assert.assertTrue(loginToYourAccountIsVisible,"Login to your account is not visible");

    }
}
