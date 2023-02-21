package tests.tests.testCase10_VerifySubscriptionInHomePage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DarknessPages.VerifySubscriptionInHomePage;
import pages.MyPages_Bilal.HomePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase10_VerifySubscriptionInHomePage_Ali {
    @Test
    public void verifySubscriptionInHomePage_test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        VerifySubscriptionInHomePage pageObject= new VerifySubscriptionInHomePage();
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Scroll down to footer
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", pageObject.subscriptionText);

        //5. Verify text 'SUBSCRIPTION'
        Assert.assertEquals(pageObject.subscriptionText.getText(),"SUBSCRIPTION","SUBSCRIPTION text is not verified.");

        //6. Enter email address in input and click arrow button
        pageObject.subscribeEmailBox.sendKeys(ConfigurationReader.getProperty("username"));
        pageObject.arrowButton.click();

        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertEquals(pageObject.successMessage.getText(),"You have been successfully subscribed!","Message is not visible");

        Driver.closeDriver();


    }
}
