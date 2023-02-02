package tests.testCase4_LogoutUser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import java.util.concurrent.TimeUnit;
public class TestCase4_LogoutUser_Tugba {
    /*Test Case 4: Logout User
1. Launch browser

*/
    WebDriver driver;
   @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    public void testCase_4_LogoutUser(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expectedHomeTitle="Automation Exercise";
        Assert.assertEquals(driver.getTitle(),expectedHomeTitle,"Title is not disable");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount=driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(loginToYourAccount.isDisplayed(),"Login to your account is not visible!");
        //6. Enter correct email address and password
        WebElement emailAddress=driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
        emailAddress.sendKeys("benjaminstrong@email.com"+ Keys.ENTER);
        WebElement emailPassword=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        emailPassword.sendKeys("benjamin"+ Keys.ENTER);
       // 7. Click 'login' button
        driver.findElement(By.xpath("(//button)[1]")).click();
        //8. Verify that 'Logged in as username' is visible

        WebElement loggedInAsUsername =driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed(),"Logged in as username is not displayed!");

        /*
        BrowserUtilities.sleep(2);
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@id='ad_iframe'])[1]")));

        WebElement iframe=driver.findElement(By.xpath("//div[@id='dismiss-button']"));
        iframe.click();


        //9. Click 'Logout' button
       WebElement logoutButton= driver.findElement(By.xpath("//a[@href='/logout']"));
        logoutButton.click();


        //10. Verify that user is navigated to login page
        String expectedLoginTitle="Login";
        Assert.assertEquals(driver.getTitle(),expectedLoginTitle,"Login title is not displayed!");

         */
    }
}
