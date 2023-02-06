package tests.tests.testCase2_LoginUserWithCorrectEmailAndPassword;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigurationReader;

import java.util.concurrent.TimeUnit;

public class TestCase2_LoginUserWithCorrectEmailAndPassword_Tugba {
    public static void main(String[] args) throws InterruptedException {
        /*Test Case 2: Login User with correct email and password

9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible*/

        //1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualTitle=driver.getTitle();
        String expectedTitle="Automation Exercise";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Home page test is PASSED");
        }else{
            System.out.println("Home Page test is FAILED!");
        }

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount=driver.findElement(By.xpath("(//h2)[1]"));
        System.out.println(loginToYourAccount.isDisplayed());
        if (loginToYourAccount.isDisplayed()==true){
            System.out.println("Login to your account test is Passed");
        }else{
            System.out.println("Login to your account test is Failed!");
        }
        //6. Enter correct email address and password


        WebElement inputEmail=driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
        inputEmail.click();
        Thread.sleep(3000);
        inputEmail.sendKeys(ConfigurationReader.getProperty("username")+ Keys.ENTER);

        WebElement inputPassword= driver.findElement(By.xpath("//input[@placeholder='Password']"));

        inputPassword.click();
        Thread.sleep(3000);
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"+ Keys.ENTER));


       // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible

    }
    }
