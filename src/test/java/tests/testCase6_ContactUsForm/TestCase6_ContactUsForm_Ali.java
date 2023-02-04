package tests.testCase6_ContactUsForm;

import org.testng.Assert;
import org.testng.annotations.Test;
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

        //3. Verify that home page is visible successfully
        //4. Click on 'Contact Us' button
        //5. Verify 'GET IN TOUCH' is visible
        //6. Enter name, email, subject and message
        //7. Upload file
        //8. Click 'Submit' button
        //9. Click OK button
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        //11. Click 'Home' button and verify that landed to home page successfully


    }
}

