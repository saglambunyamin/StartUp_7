package tests.tests.testCase14_PlaceOrderRegisterWhileCheckout;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*Test Case 16: Place Order: Login before Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button*/
public class TestCase16_PlaceOrderLoginBeforeCheckout_Mustafa {
    @Test
    public void testCase16() {
        /*1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully*/
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        pageObject.closeAdWindowByCheckingPageTitle("Automation Exercise");

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        //4. Click 'Signup / Login' button
        pageObject.signupLoginButton.click();

        //5. Fill email, password and click 'Login' button
        pageObject.loginWithExistingAccountInfo();

        //6. Verify ' Logged in as username' at top
        Assert.assertTrue(pageObject.loggedInAsUsernameText.isDisplayed());

        //7. Add products to cart randomly with given quantity
        pageObject.addItemWithGivenQuantity(3);

        //8. Click 'Cart' button
        BrowserUtilities.jsScrollClick(pageObject.cartButton);

        //9.Verify that cart page is displayed
        pageObject.verifyThatCartPageIsDisplayed();

        //10.Click Proceed To Checkout
        pageObject.proceedToCheckout.click();

        //11. Verify Address Details and Review Your Order
        pageObject.verifyDeliveryAddress();
        pageObject.verifyBillingAddress();

        //12. Enter description in comment text area and click 'Place Order'
        pageObject.addCommentAboutOrder();

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        pageObject.enterPaymentDetails();

        //14. Click 'Pay and Confirm Order' button
        //15. Verify success message 'Your order has been placed successfully!'
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
