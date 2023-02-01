package tests.testCase3_LoginUserWithIncorrectEmailAndPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestCase3_LoginUserWithIncorrectEmailAndPassword_Tugba {
    ///*Test Case 3: Login User with incorrect email and password



    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Launch browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void login_user_with_incorrect_email_and_password(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        Assert.assertEquals(driver.getTitle(),expectedTitle,"Title is not disable");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

          //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount=driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(loginToYourAccount.isDisplayed(),"Login to your account is not visible!");

        //6. Enter incorrect email address and password

        WebElement emailAddress=driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
        emailAddress.sendKeys("erdmtba@gmail.com"+ Keys.ENTER);
        WebElement emailPassword=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        emailPassword.sendKeys("123454"+ Keys.ENTER);

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button)[1]")).click();


        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement errorMessage=driver.findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(errorMessage.isDisplayed(),"Error 'Your email or password is incorrect!' is not visible");

    }

   @AfterMethod public void tearDownMethod(){
        driver.close();
    }

}
