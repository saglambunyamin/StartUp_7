package tests.tests.testCase12_AddProductsInCart;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DarknessPages.AddProductsInCartPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase12_AddProductsInCart_Ali {
    @Test
    public void addProductsInCart_test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Click 'Products' button
        AddProductsInCartPage pageObject = new AddProductsInCartPage();
        BrowserUtilities.closeAdPage_afterHomePage(pageObject.productsButton);


        //5. Hover over first product and click 'Add to cart'
        BrowserUtilities.jsScroll(pageObject.firstProduct);
        BrowserUtilities.hoverOver(pageObject.firstProduct);
        pageObject.firstProductAddToCart.click();

        //6. Click 'Continue Shopping' button
        pageObject.continueShoppingButton.click();

        //7. Hover over second product and click 'Add to cart'
        BrowserUtilities.hoverOver(pageObject.secondProduct);
        pageObject.secondProductAddToCart.click();


        //8. Click 'View Cart' button
        pageObject.viewCartButton.click();

        //9. Verify both products are added to Cart
        Assert.assertTrue(pageObject.firstAddedProduct.isDisplayed());
        Assert.assertTrue(pageObject.secondAddedProduct.isDisplayed());

        //10. Verify their prices, quantity and total price
        pageObject.verifyFirstAndSecondProductInformation();  // verify all information
    }
}
