package tests.testCase1_RegisterUser;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import reusableMethods.BrowserUtilities;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TestCase1_RegisterUser_Merve {
    public static void main(String[] args) throws InterruptedException {
        //Test Case 1: Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualHomePage = driver.getTitle();
        String expectedHomePage = "Automation Exercise";
        System.out.println("actualHomePage = " + actualHomePage);
        if (actualHomePage.equals(expectedHomePage)) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page is not visible");
        }
        //4. Click on 'Signup / Login' button
        WebElement signInButton = driver.findElement(By.xpath(" //a[contains(text(),' Signup / Login')]"));
        signInButton.click();
        //5. Verify 'New User Signup!' is visible
        WebElement titleVisible = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        System.out.println("titleVisible.isDisplayed() = " + titleVisible.isDisplayed());
        //6. Enter name and email address
        Faker faker = new Faker();

        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys(faker.name().firstName());
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys(faker.internet().emailAddress());
        //7. Click 'Signup' button
        WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpButton.click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement title2Visible = driver.findElement(By.xpath("//b[.='Enter Account Information']"));
        System.out.println("title2Visible.isDisplayed() = " + title2Visible.isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        Actions actions = new Actions(driver);
        WebElement titleButton = driver.findElement(By.xpath("//input[@id='id_gender2']"));
        titleButton.click();
        actions.sendKeys(Keys.TAB + faker.name().firstName())
                .sendKeys(Keys.TAB + faker.internet().emailAddress("merveozcam"))
                .sendKeys(Keys.TAB + faker.internet().password()).perform();
        Thread.sleep(2);
        Select dayOfBirthday = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        dayOfBirthday.selectByIndex(4);
        Select monthOfBirthday = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        monthOfBirthday.selectByVisibleText("July");
        Thread.sleep(1000);
        Select yearOfBirthday = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        yearOfBirthday.selectByValue("2000");
        BrowserUtilities.sleep(1);
       // Thread.sleep(5000);
        //10. Select checkbox 'Sign up for our newsletter!'

        WebElement signUpNewsletter = driver.findElement(By.xpath("//input[@id='newsletter']"));
        signUpNewsletter.click();
        Thread.sleep(3);
        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement receiveOffers = driver.findElement(By.xpath("//input[@id='optin']"));
        receiveOffers.click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB + faker.name().lastName())
                .sendKeys(Keys.TAB + faker.company().name())
                .sendKeys(Keys.TAB + faker.address().fullAddress())
                .sendKeys(Keys.TAB + faker.address().fullAddress())
                .sendKeys(Keys.TAB + faker.country().name())
                .sendKeys(Keys.TAB + faker.address().state())
                .sendKeys(Keys.TAB + faker.address().city())
                .sendKeys(Keys.TAB + faker.address().zipCode())
                .sendKeys(Keys.TAB + faker.phoneNumber().cellPhone()).perform();
        Thread.sleep(5);
        //13. Click 'Create Account button'
        WebElement createAccountButton = driver.findElement(By.xpath("(//button[@class='btn btn-default'])"));
        createAccountButton.sendKeys(Keys.ENTER);
        ////*[@id="form"]/div/div/div/h2/b
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement titleVerification = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        System.out.println("titleVerification.isDisplayed() = " + titleVerification.isDisplayed());
        //15. Click 'Continue' button //*[@id="form"]/div/div/div/div/a

        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
        //16. Verify that 'Logged in as username' is visible
        WebElement usernameVerification = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/i"));
        System.out.println("usernameVerification.isDisplayed() = " + usernameVerification.isDisplayed());

        WebElement iFrame= driver.findElement(By.xpath("//div[@id='dismiss_button']"));
        iFrame.click();
        Thread.sleep(2000);
        //17. Click 'Delete Account' button
        WebElement deleteAccountButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAccountButton.sendKeys(Keys.ENTER);
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedTitle = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        System.out.println("accountDeletedTitle.isDisplayed() = " + accountDeletedTitle.isDisplayed());

        WebElement continueButton2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continueButton2.sendKeys(Keys.ENTER);
        // driver.close();
        //

    }
}
