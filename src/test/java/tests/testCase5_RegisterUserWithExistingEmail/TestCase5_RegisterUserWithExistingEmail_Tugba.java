package tests.testCase5_RegisterUserWithExistingEmail;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;

import java.util.concurrent.TimeUnit;

public class TestCase5_RegisterUserWithExistingEmail_Tugba {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationexercise.com");

    }
    @Test
    public void register_User_With_Existing_Email(){
       // 3. Verify that home page is visible successfully

        String actualTitle=driver.getTitle();
        String expectedTitle="Automation Exercise";

        Assert.assertEquals(actualTitle,expectedTitle," Home Page test is FAILED!");

        //4. Click on 'Signup / Login' button

        driver.findElement(By.cssSelector("i.fa.fa-lock")).click();

       // 5. Verify 'New User Signup!' is visible
        WebElement NewUserSignupText=driver.findElement(By.cssSelector("div.signup-form>h2"));
       // Assert.assertTrue(NewUserSignupText.isDisplayed());
        System.out.println("NewUserSignupText.isDisplayed() = " + NewUserSignupText.isDisplayed());

        //6. Enter name and already registered email address
        WebElement inputName=driver.findElement(By.cssSelector("input[name='name']"));
        inputName.sendKeys("Benjamin Strong"+ Keys.ENTER);

        WebElement inputEmail=driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        inputEmail.sendKeys("benjaminstrong@email.com"+ Keys.ENTER);

     //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
     //8. Verify error 'Email Address already exist!' is visible*/
        WebElement errorMessage=driver.findElement(By.xpath("//p[.='Email Address already exist!']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        System.out.println("errorMessage.isDisplayed() = " + errorMessage.isDisplayed());

    }

}
