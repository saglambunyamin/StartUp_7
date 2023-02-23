package tests.tests.testCase13_VerifyProductQuantityInCart;

import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase13_VerifyProductQuantityInCart_Ali {

    @Test
    public void verifyProductQuantityInCart_test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Click 'View Product' for any product on home page
        //5. Verify product detail is opened
        //6. Increase quantity to 4
        //7. Click 'Add to cart' button
        //8. Click 'View Cart' button
        //9. Verify that product is displayed in cart page with exact quantity
    }
}
