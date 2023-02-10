package tests.tests.testCase13_VerifyProductQuantityInCart;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*Test Case 13: Verify Product quantity in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity*/
public class TestCase13_VerifyProductQuantityInCart_Mustafa {


    @Test
    public void testCase13() {
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        //4. Click 'View Product' for any product on home page
        pageObject.selectAnyViewProductButtonOnTheHomePage();

        pageObject.closeAdWindow();

        //5. Verify product detail is opened
        pageObject.verifyAllProductDetailsVisibility();

        /*6. Increase quantity to 4
          7. Click 'Add to cart' button*/
        pageObject.increaseItemQuantityInCart(4);

        //Click 'View Cart' button
        pageObject.viewCartButton.click();

        //Verify that product is displayed in cart page with exact quantity
        Assert.assertEquals(pageObject.productQuantityBoxInCart.getText(),"4","Product quantity ia not verified");

        Driver.getDriver().close();
    }
}
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
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
testCase14_PlaceOrderRegisterWhileCheckout*/