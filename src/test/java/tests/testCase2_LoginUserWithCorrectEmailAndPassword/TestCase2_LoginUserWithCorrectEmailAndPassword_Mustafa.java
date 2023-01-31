package tests.testCase2_LoginUserWithCorrectEmailAndPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testBase.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;

/*Test Case 2: Login User with correct email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible*/
public class TestCase2_LoginUserWithCorrectEmailAndPassword_Mustafa extends TestBaseBeforeClassAfterClass {

    @Test
    public  void loginUser() {

        driver.get(ConfigurationReader.getProperty("env"));

        String expectedTitle = "Automation Exercise";
        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Home page is visible successfully.");
        } else {
            System.out.println("Home page is not visible successfully.");
        }

        //Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("i.fa.fa-lock")).click();

        WebElement emailBox = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        actions.click(emailBox)
                .sendKeys(ConfigurationReader.getProperty("username"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigurationReader.getProperty("password"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        WebElement loginText=driver.findElement(By.cssSelector("i.fa.fa-user"));
        if(loginText.isDisplayed()){
            System.out.println("'Logged in as username' is visible");
        }else {
            System.out.println("'Logged in as username' is not visible");
        }

        WebElement deleteAccountButton=driver.findElement(By.cssSelector("i.fa.fa-trash-o"));
        deleteAccountButton.click();

        WebElement accountDeleted= driver.findElement(By.cssSelector("h2.title.text-center"));
        if(accountDeleted.isDisplayed()){
            System.out.println("ACCOUNT DELETED! is visible");
        }else {
            System.out.println("ACCOUNT DELETED! is not visible");
        }
    }


}
