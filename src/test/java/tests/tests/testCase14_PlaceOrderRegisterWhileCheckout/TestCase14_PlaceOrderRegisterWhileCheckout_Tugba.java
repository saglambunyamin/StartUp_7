package tests.tests.testCase14_PlaceOrderRegisterWhileCheckout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.Driver;

public class TestCase14_PlaceOrderRegisterWhileCheckout_Tugba {
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
    @Test
    public void place_order_register_while_checkout(){
        Driver.getDriver().get("http://automationexercise.com");

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        //4. Add products to cart
        WebElement productToCart=Driver.getDriver().findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]"));
        //5. Click 'Cart' button
        productToCart.click();
        //6. Verify that cart page is displayed
        WebElement viewCartIsDisplay=Driver.getDriver().findElement(By.xpath("(//a[@href='/view_cart'])[2]"));
        System.out.println("viewCartIsDisplay.isDisplayed() = " + viewCartIsDisplay.isDisplayed());
        //7.Click Proceed To Checkout
        WebElement proceedToCheckout=Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        proceedToCheckout.click();


    }
}