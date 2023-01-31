package tests.testCase1_RegisterUser;

import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class TestCase1_RegisterUser_Tugba {
    /*Test Case 1: Register User

*/
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

       // 3. Verify that home page is visible successfully
        String actualTitle=driver.getTitle();
        String expectedTitle="Automation Exercise";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Home page test is PASSED");
        }else{
            System.out.println("Home Page test is FAILED!");
        }
        //4. Click on 'Signup / Login' button

        WebElement signUpLoginButton= driver.findElement(By.linkText("Signup / Login"));
        signUpLoginButton.click();

        //5. Verify 'New User Signup!' is visible

        WebElement newUserSignUp=driver.findElement(By.xpath("(//h2)[3]"));
        System.out.println(newUserSignUp.isDisplayed());

         Faker faker=new Faker();
        //6. Enter name and email address
        WebElement inputName= driver.findElement(By.xpath("//input[@placeholder='Name']"));
        String fakerFirstName = faker.name().firstName(); // burda cinsiyet secebiliyormuyuz?

        inputName.sendKeys(fakerFirstName);

        WebElement inputEmail=driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]"));
        String fakerEmail=faker.internet().emailAddress();
        inputEmail.sendKeys(fakerEmail);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformationTitle=driver.findElement(By.tagName("b"));
        System.out.println(enterAccountInformationTitle.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement genderRadioButton=driver.findElement(By.xpath("//input[@id=\"id_gender2\"]"));
        genderRadioButton.click();

        WebElement inputPassword=driver.findElement(By.xpath("//input[@type='password']"));
        String fakerPassword=faker.internet().password();
        inputPassword.sendKeys(fakerPassword);

        Select daysDropDown=new Select(driver.findElement(By.xpath("//select[@id='days']")));
        Select monthsDropDown=new Select(driver.findElement(By.xpath("//select[@id='months']")));
        Select yearsDropDown=new Select(driver.findElement(By.xpath("//select[@id='years']")));

        // selectByVisibleText("1924");
        // value attribute
        // index number

        daysDropDown.selectByValue("12");
        monthsDropDown.selectByVisibleText("April");
        yearsDropDown.selectByValue("1986");

        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2000)");

        Thread.sleep(3000);
        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkBox1=driver.findElement(By.xpath("//input[@id='newsletter']"));
        checkBox1.click();

        Thread.sleep(3000);
        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkBox2=driver.findElement(By.xpath("//input[@id='optin']"));
        checkBox2.click();

        //12 Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        WebElement inputFirstName=driver.findElement(By.xpath("//input[@id='first_name']"));
        inputFirstName.sendKeys(fakerFirstName);

        WebElement inputLastName=driver.findElement(By.xpath("//input[@id='last_name']"));
        String fakerLastName=faker.name().lastName();
        inputLastName.sendKeys(fakerLastName);

        WebElement inputCompanyName=driver.findElement(By.xpath("//input[@id='company']"));
        String fakerCompanyName=faker.company().name();
        inputCompanyName.sendKeys(fakerCompanyName);

        WebElement inputAddress=driver.findElement(By.xpath("//input[@id='address1']"));
        String fakerAddress=faker.address().streetAddress();
        inputAddress.sendKeys(fakerAddress);

       Select country=new Select((driver.findElement(By.xpath("//select[@id='country']"))));
       country.selectByVisibleText("Canada");

        WebElement inputState=driver.findElement(By.xpath("//input[@id='state']"));
        String fakerState=faker.address().state();
        inputState.sendKeys(fakerState);

        WebElement inputCity=driver.findElement(By.xpath("//input[@id='city']"));
        String fakerCity=faker.address().cityName();
        inputCity.sendKeys(fakerCity);

        WebElement inputZipcode=driver.findElement(By.xpath("//input[@id='zipcode']"));
        String fakerZipcode=faker.address().zipCode();
        inputZipcode.sendKeys(fakerZipcode);

        WebElement inputMobile=driver.findElement(By.xpath("//input[@id='mobile_number']"));
        String fakerMobile=faker.phoneNumber().cellPhone();
        inputMobile.sendKeys(fakerZipcode);

        Thread.sleep(3000);
        //13. Click 'Create Account button'
        WebElement createAccountButton=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        createAccountButton.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedTitle=driver.findElement(By.tagName("b"));
        System.out.println(accountCreatedTitle.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();


        //16. Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsernameTitle=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        System.out.println(loggedInAsUsernameTitle.isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedTitle=driver.findElement(By.tagName("b"));
        System.out.println(accountDeletedTitle.isDisplayed());

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        driver.close();


    }
}
