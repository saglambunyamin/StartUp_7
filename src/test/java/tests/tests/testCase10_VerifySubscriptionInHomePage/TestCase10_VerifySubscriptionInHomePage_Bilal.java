package tests.tests.testCase10_VerifySubscriptionInHomePage;

import com.github.javafaker.Faker;
import io.netty.handler.codec.spdy.SpdyWindowUpdateFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyPages_Bilal.HomePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase10_VerifySubscriptionInHomePage_Bilal {


    @Test
    public void VerifySubscriptionInHomePage_Test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        HomePage homePage=new HomePage();
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Scroll down to footer
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", homePage.subscriptionText);

        //5. Verify text 'SUBSCRIPTION'
        Assert.assertEquals(homePage.subscriptionText.getText(),"SUBSCRIPTION");

        //6. Enter email address in input and click arrow button
        homePage.subscribeEmail.sendKeys(ConfigurationReader.getProperty("email"));
        homePage.arrowCircle.click();

        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertEquals(homePage.successMessage.getText(),"You have been successfully subscribed!");

        Driver.closeDriver();

        }

}
