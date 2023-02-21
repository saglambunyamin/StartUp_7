package tests.tests.testCase11_VerifySubscriptionInCartPage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyPages_Bilal.HomePage;
import pages.MyPages_Bilal.View_cartPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase11_VerifySubscriptionInCartPage_Bilal {

    @Test
    public void VerifySubscriptionInCartPage_test(){
        ///1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Click 'Cart' button
        HomePage homePage=new HomePage();
        homePage.click_and_closeAdPage_AfterHomePage(homePage.cartButton);

        //5. Scroll down to footer
        View_cartPage view_cartPage=new View_cartPage();
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", view_cartPage.subscriptionText);

        //6. Verify text 'SUBSCRIPTION'
        Assert.assertEquals(view_cartPage.subscriptionText.getText(),"SUBSCRIPTION");

        view_cartPage.subscribeEmail.sendKeys(ConfigurationReader.getProperty("email"));
        view_cartPage.arrowCircle.click();

        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertEquals(view_cartPage.successMessage.getText(),"You have been successfully subscribed!");

        Driver.closeDriver();
    }


}
