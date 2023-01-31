package tests.testCase1_RegisterUser;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reusableMethods.BrowserUtilities;
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
      System.out.println("New User Signup is visible");
       }else{
           System.out.println("New User Signup is not visible");
       }

    //6. Enter name and email address
        Faker faker= new Faker();
        WebElement inputName= Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-name']"));
        String userName= faker.name().fullName();
        inputName.sendKeys(userName);

        BrowserUtilities.sleep(2);

        WebElement inputEmail= Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-email']"));
        String emailAdress= faker.internet().emailAddress();
        inputEmail.sendKeys(emailAdress);

        BrowserUtilities.sleep(2);

    //7. Click 'Signup' button
       WebElement signUpButton= Driver.getDriver().findElement(By.xpath("//button[@data-qa='signup-button']"));
       signUpButton.click();

    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
      WebElement enterAccountInfo= Driver.getDriver().findElement(By.xpath("//b[.='Enter Account Information']"));
      if(enterAccountInfo.isDisplayed()){
         System.out.println("Enter Account Information is visible");
      }else{
         System.out.println("Enter Account Information is not visible");
     }

    //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement titleGender= Driver.getDriver().findElement(By.xpath("//input[@value='Mr']"));
        titleGender.click();

        BrowserUtilities.sleep(2);

        WebElement enterPassword= Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        String enterRandomPassword= faker.numerify("##############");
        enterPassword.sendKeys(enterRandomPassword);

        BrowserUtilities.sleep(2);

        Select enterDayOfBirth= new Select( Driver.getDriver().findElement(By.xpath("//select[@id='days']")));
        enterDayOfBirth.selectByValue("8");

        Select enterMonthOfBirth= new Select( Driver.getDriver().findElement(By.xpath("//select[@id='months']")));
        enterMonthOfBirth.selectByVisibleText("May");

        Select enterYearOfBirth= new Select( Driver.getDriver().findElement(By.xpath("//select[@id='years']")));
        enterYearOfBirth.selectByValue("2000");

        BrowserUtilities.sleep(2);

    //10. Select checkbox 'Sign up for our newsletter!'
        WebElement selectSignUpForNews= Driver.getDriver().findElement(By.xpath("//input[@name='newsletter']"));
        selectSignUpForNews.click();

    //11. Select checkbox 'Receive special offers from our partners!'
        WebElement selectReceiveSpecialOffer= Driver.getDriver().findElement(By.xpath("//input[@name='optin']"));
        selectReceiveSpecialOffer.click();

        BrowserUtilities.sleep(2);

    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
      WebElement fillFirstName= Driver.getDriver().findElement(By.xpath("//input[@name='first_name']"));
      String fillFirstN= faker.name().firstName();
      fillFirstName.sendKeys(fillFirstN);

      WebElement fillLastName= Driver.getDriver().findElement(By.xpath("//input[@name='last_name']"));
      String fillLastNm= faker.name().lastName();
      fillLastName.sendKeys(fillLastNm);

      WebElement fillCompanyName= Driver.getDriver().findElement(By.xpath("//input[@name='company']"));
      String fillConpanyNm= faker.company().name();
      fillCompanyName.sendKeys(fillConpanyNm);

      WebElement fillAddress1= Driver.getDriver().findElement(By.xpath("//input[@name='address1']"));
      String fillAddress= faker.address().fullAddress();
      fillAddress1.sendKeys(fillAddress);

      WebElement fillAddress2= Driver.getDriver().findElement(By.xpath("//input[@name='address2']"));
      String fillAddressSecond= faker.address().secondaryAddress();
      fillAddress2.sendKeys(fillAddressSecond);

      Select fillCountryName= new Select( Driver.getDriver().findElement(By.xpath("//select[@id='country']")));
      fillCountryName.selectByVisibleText("Canada");

      WebElement fillStateName= Driver.getDriver().findElement(By.xpath("//input[@id='state']"));
      String fillStateNm= faker.country().name();
      fillStateName.sendKeys(fillStateNm);

      WebElement fillCityName= Driver.getDriver().findElement(By.xpath("//input[@id='city']"));
      String fillCityNm= faker.country().name();
      fillCityName.sendKeys(fillCityNm);

      WebElement fillZipCode= Driver.getDriver().findElement(By.xpath("//input[@id='zipcode']"));
      String fillZipCd= faker.bothify("????####");
      fillZipCode.sendKeys(fillZipCd);

      WebElement fillMobileNumber= Driver.getDriver().findElement(By.xpath("//input[@id='mobile_number']"));
      String fillMobileNm= faker.numerify("### #######");
      fillMobileNumber.sendKeys(fillMobileNm);

      BrowserUtilities.sleep(2);

    //13. Click 'Create Account button'
      WebElement clickCreateAccount= Driver.getDriver().findElement(By.xpath("//button[@data-qa='create-account']"));
      clickCreateAccount.click();

    //14. Verify that 'ACCOUNT CREATED!' is visible
      WebElement accountCreatedTest= Driver.getDriver().findElement(By.xpath("//b[.='Account Created!']"));
      if(accountCreatedTest.isDisplayed()){
         System.out.println("Account Created is visible");
      }else{
         System.out.println("Account Created is not visible");
        }

    //15. Click 'Continue' button
      WebElement continueButton= Driver.getDriver().findElement(By.xpath("//a[@data-qa='continue-button']"));
      continueButton.click();

    //16. Verify that 'Logged in as username' is visible
      WebElement verifyLoggedIn= Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-user']"));
      if(verifyLoggedIn.isDisplayed()){
        System.out.println("Logged in as username is visible");
       }else{
       System.out.println("Logged in as username is  not visible");
        }
       BrowserUtilities.sleep(2);

    //17. Click 'Delete Account' button
      WebElement deleteAccountButton= Driver.getDriver().findElement(By.xpath("//a[@href='/delete_account']"));
      deleteAccountButton.click();

    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
      WebElement accountDeletedVisible= Driver.getDriver().findElement(By.xpath("//b[.='Account Deleted!']"));
      if(accountDeletedVisible.isDisplayed()){
       System.out.println("Account Deleted is visible");
       }else{
       System.out.println("Account Deleted is  not visible");
       }

       Driver.getDriver().close();
}
}