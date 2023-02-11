package tests.tests.testCase14_PlaceOrderRegisterWhileCheckout;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*Test Case 14: Place Order: Register while Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button*/
public class TestCase14_PlaceOrderRegisterWhileCheckout_Mustafa {


    @Test
    public void testCase14() {
        /*1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully*/
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        //4. Add products to cart
        pageObject.addItemWithGivenQuantity(3);

        //5. Click 'Cart' button
        BrowserUtilities.jsScrollClick(pageObject.cartButton);

        //6.Verify that cart page is displayed
        pageObject.verifyThatCartPageIsDisplayed();

        //7.Click Proceed To Checkout
        pageObject.proceedToCheckout.click();

        //8. Click 'Register / Login' button
        pageObject.registerLoginButton.click();

        //9. Fill all details in Signup and create account
        pageObject.createNewUserAccount();

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        pageObject.verifyAccountCreation();

        //11. Verify ' Logged in as username' at top
        Assert.assertTrue(pageObject.loggedInAsUsernameText.isDisplayed());

        //12. Click 'Cart' button
        pageObject.cartButton.click();

        //13. Click 'Proceed To Checkout' button
        pageObject.proceedToCheckout.click();

        //14. Verify Address Details and Review Your Order
        pageObject.verifyDeliveryAddress();
        pageObject.verifyBillingAddress();

        //15. Enter description in comment text area and click 'Place Order'
        pageObject.addCommentAboutOrder();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        pageObject.enterPaymentDetails();

        //18. Verify success message 'Your order has been placed successfully!'
        Assert.assertEquals(pageObject.orderSuccessfullyPlacedMessage.getText(),"Your order has been placed successfully!");

        //19. Click 'Delete Account' button
        BrowserUtilities.jsScrollClick( pageObject.deleteAccountButton);

        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        pageObject.verifyAccountDeletedTextAndClickContButton();

        Driver.getDriver().close();
    }
}
