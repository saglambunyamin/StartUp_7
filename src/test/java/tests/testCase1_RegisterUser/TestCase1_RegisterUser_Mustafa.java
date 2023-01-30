package tests.testCase1_RegisterUser;

/*Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
*/

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import reusableMethods.BrowserUtilities;
import testBase.TestBaseBeforeClassAfterClass;

import java.util.concurrent.TimeUnit;

public class TestCase1_RegisterUser_Mustafa {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://automationexercise.com");

        String expectedTitle = "Automation Exercise";
        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Home page is visible successfully.");
        } else {
            System.out.println("Home page is not visible successfully.");

        }

        //Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("i.fa.fa-lock")).click();

        WebElement newUserSignup = driver.findElement(By.xpath("(//h2)[3]"));
        newUserSignup.isDisplayed();
        if (newUserSignup.getText().equals("New User Signup!")) {
            System.out.println("New User Signup! is visible");
        } else {
            System.out.println("New User Signup! is not visible");

        }

        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        WebElement nameBox = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        actions.click(nameBox)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        WebElement enterAccountInfo = driver.findElement(By.xpath("(//h2)[1]"));
        enterAccountInfo.isDisplayed();

        WebElement genderRadioButton = driver.findElement(By.cssSelector("input#id_gender1"));
        genderRadioButton.click();

        BrowserUtilities.sleep(5);

        WebElement password = driver.findElement(By.cssSelector("input#password"));
        actions.click(password)
                .sendKeys(faker.internet().password()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys("" + faker.number().numberBetween(1, 31)).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys("May").pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys("" + faker.number().numberBetween(1900, 2021)).pause(3000)
                .sendKeys(Keys.TAB).click().perform();

        BrowserUtilities.sleep(5);

        WebElement firstName = driver.findElement(By.cssSelector("input#first_name"));
        actions.click(firstName)
                .sendKeys(faker.name().firstName()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Canada").perform();

        BrowserUtilities.sleep(5);

        WebElement state = driver.findElement(By.cssSelector("input#state"));
        actions.click(state)
                .sendKeys(faker.address().state()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).pause(3000)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).pause(3000).perform();

        WebElement createAccountButton=driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]"));
        createAccountButton.click();

        WebElement accountCreation = driver.findElement(By.xpath("(//h2)[1]"));
        accountCreation.isDisplayed();
        if (accountCreation.getText().equals("ACCOUNT CREATED!")) {
            System.out.println("ACCOUNT CREATED! is visible");
        } else {
            System.out.println("ACCOUNT CREATED! is not visible");
        }

        WebElement continueButton=driver.findElement(By.cssSelector("a.btn.btn-primary"));
        continueButton.click();

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

        WebElement contButton= driver.findElement(By.cssSelector("a.btn.btn-primary"));
        contButton.click();

        System.out.println("We are done!");
    }
}
