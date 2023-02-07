package tests.tests.testCase6_ContactUsForm;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TestCase6_ContactUsForm_Benjamin {

    @Test
    public void ContactUsFormTest () {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");

        //4. Click on 'Contact Us' button
        WebElement contactUsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/contact_us']"));
        contactUsButton.click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchText = Driver.getDriver().findElement(By.xpath("//h2[.='Get In Touch']"));
        Assert.assertTrue(getInTouchText.isDisplayed());

        Faker faker = new Faker();
        //6. Enter name, email, subject and message
        WebElement nameInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        nameInputBox.sendKeys(faker.name().fullName());

        WebElement emailInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailInputBox.sendKeys(faker.name().username() + "@mail.com");

        WebElement subjectInput = Driver.getDriver().findElement(By.xpath("//input[@name='subject']"));
        subjectInput.sendKeys(faker.company().profession());

        WebElement yourMessageHereInputBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='message']"));
        yourMessageHereInputBox.sendKeys("My message");

        //7. Upload file
        WebElement uploadFileButton = Driver.getDriver().findElement(By.xpath("//input[@name='upload_file']"));
        String fileDirectory = "C:\\Users\\hp\\Desktop\\File.txt";
        uploadFileButton.sendKeys(fileDirectory);

        //8. Click 'Submit' button
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//input[@name='submit']"));
        submitButton.click();

        //9. Click OK button
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement submitMessage = Driver.getDriver().findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertEquals(submitMessage.getText(), "Success! Your details have been submitted successfully.");

        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement homeButton = Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-angle-double-left']"));
        homeButton.click();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise - Contact Us");

        Driver.getDriver().quit();

    }

}
