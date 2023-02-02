package tests.testCase5_RegisterUserWithExistingEmail;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import testBase.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;
/*Test Case 5: Register User with existing email
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible*/
public class TestCase5_RegisterUserWithExistingEmail_Mustafa extends TestBaseBeforeClassAfterClass {
    Faker faker=new Faker();
    String userName = faker.name().username();
    String emailAddress=faker.internet().emailAddress();
    String password=faker.internet().password();
    @Test()
    public void test1() {
        driver.get(ConfigurationReader.getProperty("env"));

        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home page is not visible successfully.");

        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();

        WebElement newUserSignup = driver.findElement(By.cssSelector("div.signup-form>h2"));
        boolean newUserSignupIsVisible = newUserSignup.isDisplayed();
        Assert.assertTrue(newUserSignupIsVisible, "New User Signup! is not visible");

        //Firstly create a new account, log out and again try to create a new account with existing info
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
        nameBox.sendKeys(userName);

        WebElement emailAddressBox = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailAddressBox.sendKeys(emailAddress);

        WebElement signupButton = driver.findElement(By.xpath("//button[.='Signup']"));
        signupButton.click();

        // Fill details: Title, Name, Email, Password, Date of birth
        WebElement titleGender = driver.findElement(By.cssSelector("input#id_gender1"));
        titleGender.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        BrowserUtilities.sleep(2);

        WebElement accountPassword = driver.findElement(By.xpath("//input[@id='password']"));
        accountPassword.sendKeys(password);

        Select selectDayDropdown = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        selectDayDropdown.selectByValue(faker.number().numberBetween(1, 31) + "");
        BrowserUtilities.sleep(1);

        Select selectMonthDropdown = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        selectMonthDropdown.selectByValue(faker.number().numberBetween(1, 12) + "");
        BrowserUtilities.sleep(1);

        Select selectYearDropdown = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectYearDropdown.selectByValue(faker.number().numberBetween(1900, 2021) + "");
        BrowserUtilities.sleep(1);

        // Select checkbox 'Receive special offers from our partners!'
        WebElement signUpForOurNewsletterBox = driver.findElement(By.xpath("//label[.='Sign up for our newsletter!']"));
        BrowserUtilities.sleep(1);
        signUpForOurNewsletterBox.click();

        WebElement receiveSpecialOffersFromOurPartnersBox = driver.findElement(By.xpath("//label[.='Receive special offers from our partners!']"));
        BrowserUtilities.sleep(1);
        receiveSpecialOffersFromOurPartnersBox.click();

        js.executeScript("window.scrollBy(0,300)");
        BrowserUtilities.sleep(2);

        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@id='first_name']"));
        actions.click(firstNameBox).sendKeys(faker.name().firstName()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //Logout
        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();
        BrowserUtilities.sleep(3);
        driver.findElement(By.xpath("//a[.=' Logout']")).click();

        System.out.println("These user infos are created. We will try to use them again to verify the expected error\n"+userName+"\n"+emailAddress);
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        //Step-6: Enter name and already registered email address, verify the error
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
        actions.click(nameBox)
                .sendKeys(userName)
                .sendKeys(Keys.TAB)
                .sendKeys(emailAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        WebElement loginText=driver.findElement(By.xpath("//*[contains(text(),'already exist!')]"));
        if(loginText.isDisplayed()){
            System.out.println("Email Address already exist!");
        }else {
            System.out.println("Email Address already exist! is not visible");
        }
    }
}
