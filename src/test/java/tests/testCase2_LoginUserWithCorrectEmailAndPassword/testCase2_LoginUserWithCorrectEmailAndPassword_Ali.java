package tests.testCase2_LoginUserWithCorrectEmailAndPassword;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class testCase2_LoginUserWithCorrectEmailAndPassword_Ali {
    public static void main(String[] args) {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3. Verify that home page is visible successfully
        //4. Click on 'Signup / Login' button
        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        //7. Click 'login' button
        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible
    }
}
