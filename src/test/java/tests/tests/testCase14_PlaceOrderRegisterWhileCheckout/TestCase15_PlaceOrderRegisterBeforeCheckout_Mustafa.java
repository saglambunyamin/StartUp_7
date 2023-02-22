package tests.tests.testCase14_PlaceOrderRegisterWhileCheckout;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*Test Case 15: Place Order: Register before Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify Address Details and Review Your Order
13. Enter description in comment text area and click 'Place Order'
14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
15. Click 'Pay and Confirm Order' button
16. Verify success message 'Your order has been placed successfully!'
17. Click 'Delete Account' button
18. Verify 'ACCOUNT DELETED!' and click 'Continue' button*/
public class TestCase15_PlaceOrderRegisterBeforeCheckout_Mustafa {
    @Test
    public void testCase15() {
        /*1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully*/
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        pageObject.closeAdWindowByCheckingPageTitle("Automation Exercise");

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        //4. Click 'Signup / Login' button
        pageObject.signupLoginButton.click();

        //5. Fill all details in Signup and create account
        pageObject.createNewUserAccount();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        pageObject.verifyAccountCreation();

        //7. Verify ' Logged in as username' at top
        Assert.assertTrue(pageObject.loggedInAsUsernameText.isDisplayed());

        //8. Add products to cart randomly with given quantity
        pageObject.addItemWithGivenQuantity(3);

        //9. Click 'Cart' button
        BrowserUtilities.jsScrollClick(pageObject.cartButton);

        //10.Verify that cart page is displayed
        pageObject.verifyThatCartPageIsDisplayed();

        //11.Click Proceed To Checkout
        pageObject.proceedToCheckout.click();

        //12. Verify Address Details and Review Your Order
        pageObject.verifyDeliveryAddress();
        pageObject.verifyBillingAddress();

        //13. Enter description in comment text area and click 'Place Order'
        pageObject.addCommentAboutOrder();

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        pageObject.enterPaymentDetails();

        //15. Click 'Pay and Confirm Order' button
        //16. Verify success message 'Your order has been placed successfully!'
        BrowserUtilities.jsScroll(pageObject.subscriptionMailBox);
        BrowserUtilities.jsScrollClick(pageObject.payAndConfirmOrder);
        Assert.assertTrue(pageObject.orderSuccessfullyPlacedMessage.isDisplayed());

        //17. Click 'Delete Account' button
        BrowserUtilities.jsScrollClick( pageObject.deleteAccountButton);

        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        pageObject.verifyAccountDeletedTextAndClickContButton();

        Driver.getDriver().close();
    }
}
