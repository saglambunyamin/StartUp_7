package tests.tests.testCase10_VerifySubscriptionInHomePage;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import tests.tests.testCase5_RegisterUserWithExistingEmail.TestCase5_RegisterUserWithExistingEmail_Mustafa;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*Test Case 10: Verify Subscription in home page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
7. Verify success message 'You have been successfully subscribed!' is visible*/
public class TestCase10_VerifySubscriptionInHomePage_Mustafa {


    @Test(groups = "TestCase5_RegisterUserWithExistingEmail_Mustafa.test1()")//Before testCase10() go to the testCase5() and create a new account. Then use new email info for this test case
    public void testCase10() {
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        BrowserUtilities.jsScroll(pageObject.subscriptionText);

        Assert.assertEquals(pageObject.subscriptionText.getText(),"SUBSCRIPTION","SUBSCRIPTION text is nor verified!");

        //6. Enter email address in input and click arrow button (Create a new account and use it's data for subscription)
        pageObject.subscriptionMailBox.sendKeys(new TestCase5_RegisterUserWithExistingEmail_Mustafa().emailAddress+ Keys.ENTER);
        System.out.println(new TestCase5_RegisterUserWithExistingEmail_Mustafa().emailAddress);

        //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertEquals(pageObject.successfullySubscribedText.getText(),"You have been successfully subscribed!","SUBSCRIPTION verification is not passed!");
        System.out.println(pageObject.successfullySubscribedText.getText());

        Driver.getDriver().close();
    }
}