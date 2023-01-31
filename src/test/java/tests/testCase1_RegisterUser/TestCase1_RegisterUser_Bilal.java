package tests.testCase1_RegisterUser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import testBase.TestBaseBeforeClassAfterClass;

import java.util.concurrent.TimeUnit;


public class TestCase1_RegisterUser_Bilal extends TestBaseBeforeClassAfterClass {


      @Test
      public void RegisterUserTest(){

      //1. Launch browser
      //2. Navigate to url 'http://automationexercise.com'
      driver.get("https://automationexercise.com/");

       //3. Verify that home page is visible successfully
       String expectedTitle = "Automation Exercise";
       if (driver.getTitle().equals(expectedTitle)){
           System.out.println("Page Verification PASSED");
       }else {
           System.out.println("Page Verification FAİLED");
       }
       // 4. Click on 'Signup / Login' button
       driver.findElement(By.xpath("//a[@href='/login']")).click();
       BrowserUtilities.sleep(2);

       //5. Verify 'New User Signup!' is visible
       String newUserSingUp=driver.findElement(By.xpath("//h2[.='New User Signup!']")).getText();

       if (newUserSingUp.equals("New User Signup!")){
           System.out.println("'New User Signup!' is VISIBLE");
       }else {
           System.out.println("'New User Signup!' is NOT VISIBLE");
       }

       //6. Enter name and email address
       String userName= faker.name().username();
       driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
       driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());

       //7. Click 'Signup' button
       driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
       BrowserUtilities.sleep(2);

       //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
       String enterAccountInformation= driver.findElement(By.xpath("//b[.='Enter Account Information']")).getText();
       if (enterAccountInformation.equals("ENTER ACCOUNT INFORMATION")){
           System.out.println("'ENTER ACCOUNT INFORMATION' is VISIBLE");
       }else {
           System.out.println("'ENTER ACCOUNT INFORMATION' is NOT VISIBLE");
       }

       //9. Fill details: Title, Name, Email, Password, Date of birth
       driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
       driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys(faker.internet().password());

       Select selectDay= new Select(driver.findElement(By.xpath("//select[@data-qa='days']")));
       Select selectMonth= new Select(driver.findElement(By.xpath("//select[@data-qa='months']")));
       Select selectYear= new Select(driver.findElement(By.xpath("//select[@data-qa='years']")));

       selectDay.selectByIndex(faker.number().numberBetween(1,31));
       selectMonth.selectByIndex(faker.number().numberBetween(1,12));
       selectYear.selectByIndex(faker.number().numberBetween(1,100));


       //10. Select checkbox 'Sign up for our newsletter!'
       driver.findElement(By.xpath("//input[@id='newsletter']")).click();

       //11. Select checkbox 'Receive special offers from our partners!'
       driver.findElement(By.xpath("//input[@id='optin']")).click();

       //12. Fill details: First name, Last name, Company, Address, Address2, Country...
       driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName());
       driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(faker.name().lastName());
       driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
       driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().fullAddress());
       Select selectCountry= new Select(driver.findElement(By.xpath("//select[@data-qa='country']")));
       selectCountry.selectByIndex(faker.number().numberBetween(0,6));

       //...State, City, Zipcode, Mobile Number
       driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
       driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
       driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
       driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.numerify("###-###-####"));

       BrowserUtilities.sleep(2);
       driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();


       //14. Verify that 'ACCOUNT CREATED!' is visible
       BrowserUtilities.sleep(2);
       String accountCreatedVerify= driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
       System.out.println(accountCreatedVerify);
       if (accountCreatedVerify.equals("ACCOUNT CREATED!")){
           System.out.println("'ACCOUNT CREATED!' is VISIBLE");
       }else {
           System.out.println("'ACCOUNT CREATED!' is NOT VISIBLE");
       }

       //15. Click 'Continue' button
       BrowserUtilities.sleep(2);
       driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

       BrowserUtilities.sleep(2);
       driver.switchTo().frame("aswift_2");
       driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ad_iframe']")));
       driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
       driver.switchTo().parentFrame();

       BrowserUtilities.sleep(2);
       //16. Verify that 'Logged in as username' is visible
       String loggedInVerify= driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[10]/a/i")).getText();
       System.out.println(loggedInVerify);
       if (loggedInVerify.equals(" Logged in as  " + userName)){
           System.out.println("'Logged in as username' is VISIBLE");
       }else {
           System.out.println("'Logged in as username' is NOT VISIBLE");
       }

       //17. Click 'Delete Account' button
       BrowserUtilities.sleep(2);
       driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]")).click();


       //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
       String deletedVerify= driver.findElement(By.xpath("//b[.='Account Deleted!']")).getText();
       if (deletedVerify.equals("ACCOUNT DELETED!")){
                 System.out.println("'ACCOUNT DELETED!' is VISIBLE");
       }else {
                 System.out.println("'ACCOUNT DELETED!' is NOT VISIBLE");
       }




   }
}

