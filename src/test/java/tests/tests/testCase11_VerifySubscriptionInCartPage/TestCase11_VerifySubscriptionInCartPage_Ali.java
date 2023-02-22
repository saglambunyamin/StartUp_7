package tests.tests.testCase11_VerifySubscriptionInCartPage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DarknessPages.VerifySubscriptionInCartPage;
import pages.DarknessPages.VerifySubscriptionInHomePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase11_VerifySubscriptionInCartPage_Ali {
    @Test
    public void verifySubscriptionInCartPage_test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        VerifySubscriptionInCartPage pageObject = new VerifySubscriptionInCartPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Click 'Cart' button
        pageObject.cartButton.click();

        //5. Scroll down to footer
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", pageObject.subscriptionText);

        //6. Verify text 'SUBSCRIPTION'
        Assert.assertEquals(pageObject.subscriptionText.getText(),"SUBSCRIPTION","SUBSCRIPTION text is not verified.");

        //7. Enter email address in input and click arrow button
        pageObject.subscribeEmailBox.sendKeys(ConfigurationReader.getProperty("username"));
        pageObject.arrowButton.click();

        //8. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertEquals(pageObject.successMessage.getText(),"You have been successfully subscribed!","Message is not visible");

    }
}
