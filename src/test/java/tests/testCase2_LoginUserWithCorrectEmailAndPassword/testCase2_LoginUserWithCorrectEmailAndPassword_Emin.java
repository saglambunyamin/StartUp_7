package tests.testCase2_LoginUserWithCorrectEmailAndPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class testCase2_LoginUserWithCorrectEmailAndPassword_Emin {
    public static void main(String[] args) {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle= "Automation Exercise";
        String actualTitle= Driver.getDriver().getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Home page is visible");
        }else{
            System.out.println("Home page is not visible");
        }

        //4. Click on 'Signup / Login' button
        WebElement signUpLoginButton= Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
        signUpLoginButton.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount= Driver.getDriver().findElement(By.xpath("//h2[.='Login to your account']"));
        if(loginToYourAccount.isDisplayed()){
            System.out.println("Login to your account is visible");
        }else{
            System.out.println("Login to your account is not visible");
        }

        //6. Enter correct email address and password



        //7. Click 'login' button
        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible







    }
}
