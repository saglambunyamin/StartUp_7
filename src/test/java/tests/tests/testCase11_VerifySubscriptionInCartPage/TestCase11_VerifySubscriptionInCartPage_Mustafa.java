package tests.tests.testCase11_VerifySubscriptionInCartPage;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import tests.tests.testCase5_RegisterUserWithExistingEmail.TestCase5_RegisterUserWithExistingEmail_Mustafa;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;
/*Test Case 11: Verify Subscription in Cart page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
8. Verify success message 'You have been successfully subscribed!' is visible*/
public class TestCase11_VerifySubscriptionInCartPage_Mustafa {


    @Test(groups = "TestCase5_RegisterUserWithExistingEmail_Mustafa.test1()")//Before testCase10() go to the testCase5() and create a new account. Then use new email info for this test case
    public void testCase11() {
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        pageObject.cartButton.click();

        BrowserUtilities.jsScroll(pageObject.subscriptionText);

        Assert.assertEquals(pageObject.subscriptionText.getText(),"SUBSCRIPTION","SUBSCRIPTION text is nor verified!");

        pageObject.subscriptionMailBox.sendKeys(new TestCase5_RegisterUserWithExistingEmail_Mustafa().emailAddress+ Keys.ENTER);
        System.out.println(new TestCase5_RegisterUserWithExistingEmail_Mustafa().emailAddress);

        Assert.assertEquals(pageObject.successfullySubscribedText.getText(),"You have been successfully subscribed!","SUBSCRIPTION verification is not passed!");
        System.out.println(pageObject.successfullySubscribedText.getText());

        Driver.getDriver().close();
    }
}
