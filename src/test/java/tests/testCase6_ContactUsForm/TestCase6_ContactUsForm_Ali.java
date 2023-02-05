package tests.testCase6_ContactUsForm;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase6_ContactUsForm_Ali {
    @Test
    public void contactUsForm_test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Home page is not visible");

        //4. Click on 'Contact Us' button
        WebElement contactUsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/contact_us']"));
        contactUsButton.click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchText = Driver.getDriver().findElement(By.xpath("//h2[.='Get In Touch']"));
        if (getInTouchText.isDisplayed()) {
            System.out.println(getInTouchText.getText()+" is visible");
        } else {
            System.out.println("GET IN TOUCH is not visible");
        }

        //6. Enter name, email, subject and message
        Faker faker = new Faker();
        String name = faker.name().username();
        String email = faker.internet().emailAddress();
        String subject= faker.lorem().sentence();
        String message = faker.lorem().paragraph();

        Actions actions=new Actions(Driver.getDriver());

        WebElement nameBox =  Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        actions.click(nameBox).sendKeys(name)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(subject)
                .sendKeys(Keys.TAB)
                .sendKeys(message).perform();



        //7. Upload file
        WebElement uploadFileButton = Driver.getDriver().findElement(By.xpath("//input[@name='upload_file']"));
        String filePath = "C:\\Users\\user\\Desktop\\Exceptions.png";
        uploadFileButton.sendKeys(filePath);

        //8. Click 'Submit' button
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//input[@name='submit']"));
        submitButton.click();

        //9. Click OK button
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@class='status alert alert-success']"));

        if (successMessage.isDisplayed()) {
            System.out.println(successMessage.getText()+" is visible");
        } else {
            System.out.println("Success! Your details have been submitted successfully. is not visible");
        }

        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement homeButton = Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-angle-double-left']"));
        homeButton.click();
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise - Contact Us");

    }

}

