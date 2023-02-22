package tests.tests.testCase13_VerifyProductQuantityInCart;

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
