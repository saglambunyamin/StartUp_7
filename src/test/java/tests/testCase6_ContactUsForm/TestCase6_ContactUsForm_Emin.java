package tests.testCase6_ContactUsForm;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reusableMethods.BrowserUtilities;
import utilities.Driver;
import utilities.WebDriverFactory;

public class TestCase6_ContactUsForm_Emin {
    public static void main(String[] args) {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

    //3. Verify that home page is visible successfully
        String expectedTitle= "Automation Exercise";
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"home page is not visible");

    //4. Click on 'Contact Us' button
        WebElement contactUsButton= Driver.getDriver().findElement(By.xpath("//a[@href='/contact_us']"));
        contactUsButton.click();

    //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch= Driver.getDriver().findElement(By.xpath("//h2[.='Get In Touch']"));
        Assert.assertTrue(getInTouch.isDisplayed());

    //6. Enter name, email, subject and message
        Faker faker=new Faker();

        String name= faker.name().fullName();
        WebElement enterName= Driver.getDriver().findElement(By.xpath("//input[@data-qa='name']"));
        enterName.sendKeys(name);

        BrowserUtilities.sleep(2);

        String email= faker.internet().emailAddress();
        WebElement enterEmail= Driver.getDriver().findElement(By.xpath("//input[@data-qa='email']"));
        enterEmail.sendKeys(email);

        BrowserUtilities.sleep(2);

        String subject= faker.lorem().sentence();
        WebElement enterSubject= Driver.getDriver().findElement(By.xpath("//input[@data-qa='subject']"));
        enterSubject.sendKeys(subject);

        BrowserUtilities.sleep(2);

        String message= faker.lorem().paragraph();
        WebElement enterMessage= Driver.getDriver().findElement(By.xpath("//textarea[@data-qa='message']"));
        enterMessage.sendKeys(message);

        BrowserUtilities.sleep(2);

    //7. Upload file
        WebElement uploadButton= Driver.getDriver().findElement(By.xpath("//input[@name='upload_file']"));
        String loadedFile= "C:\\Users\\yusuf kemal\\Pictures\\Nirvana";
        uploadButton.sendKeys(loadedFile);

    //8. Click 'Submit' button
        WebElement submitButton= Driver.getDriver().findElement(By.xpath("//input[@data-qa='submit-button']"));
        submitButton.click();

        BrowserUtilities.sleep(2);

    //9. Click OK button
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successMessage= Driver.getDriver().findElement(By.xpath("//div[.='Success! Your details have been submitted successfully.']"));
        Assert.assertEquals(successMessage.getText(), "Success! Your details have been submitted successfully.");

        BrowserUtilities.sleep(2);

    //11. Click 'Home' button and verify that landed to home page successfully
        WebElement homeButton= Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-angle-double-left']"));
        homeButton.click();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise - Contact Us");

    Driver.getDriver().quit();

    }
}
