package tests.tests.testCase12_AddProductsInCart;

import org.testng.annotations.Test;
import pages.MyPages_Bilal.HomePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase12_AddProductsInCart_Bilal {

    @Test
    public void AddProductsInCart_Test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //    4. Click on 'Products' button
        HomePage homePage= new HomePage();
        homePage.closeAdPage_AfterHomePage(homePage.productsButton);

        //5. Hover over first product and click 'Add to cart'
        //6. Click 'Continue Shopping' button
        //7. Hover over second product and click 'Add to cart'
        //8. Click 'View Cart' button
        //9. Verify both products are added to Cart
        //10. Verify their prices, quantity and total price

    }

}
