package tests.tests.testCase6_ContactUsForm;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TestCase6_ContactUsForm_Merve {
    /*Test Case 6: Contact Us Form
testCase6_ContactUsForm
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully*/


    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void RegisterUser() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");
        //4. Click on 'Contact Us' button
        WebElement contactUsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/contact_us']"));
        contactUsButton.sendKeys(Keys.ENTER);
// 5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = Driver.getDriver().findElement(By.xpath("//h2[.='Get In Touch']"));
        System.out.println("getInTouch.isDisplayed() = " + getInTouch.isDisplayed());
        //6. Enter name, email, subject and message

        Faker faker = new Faker();

        WebElement name = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(faker.name().username());
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB + faker.internet().emailAddress())
                .sendKeys(Keys.TAB + faker.company().profession())
                .sendKeys(Keys.TAB + faker.chuckNorris().fact()).perform();
        //7. Upload file
        //8. Click 'Submit' button
        //9. Click OK button

        WebElement uploadFile = Driver.getDriver().findElement(By.xpath("//input[@name=\"upload_file\"]"));
        String path = "C:\\Users\\Samsung\\Desktop\\HTML CLASS\\buranoVenice.jpg";
        uploadFile.sendKeys(path);

        WebElement submitButton= Driver.getDriver().findElement(By.cssSelector("input[name='submit']"));
        submitButton.submit();

        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@class='status alert alert-success']"));
        System.out.println("successMessage.isDisplayed() = " + successMessage.isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement homeButton = Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-angle-double-left']"));
        homeButton.click();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise - Contact Us");

    }
}
