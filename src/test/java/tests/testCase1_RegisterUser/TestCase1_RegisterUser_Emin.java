package tests.testCase1_RegisterUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase1_RegisterUser_Emin {
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
   WebElement signupLoginButton= Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
   signupLoginButton.click();

    //5. Verify 'New User Signup!' is visible
    WebElement newUserSignup= Driver.getDriver().findElement(By.xpath("//h2[.='New User Signup!']"));
    if(newUserSignup.isDisplayed()){
     System.out.println("New User Signup! is visible");
       }else{
           System.out.println("New User Signup! is not visible");
       }

    //6. Enter name and email address



    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
}
}