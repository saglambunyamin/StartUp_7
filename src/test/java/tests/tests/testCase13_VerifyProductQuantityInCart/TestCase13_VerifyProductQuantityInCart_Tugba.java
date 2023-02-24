package tests.tests.testCase13_VerifyProductQuantityInCart;

import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import pages.MyPages_Bilal.HomePage;
import pages.MyPages_Bilal.ProductsPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class TestCase13_VerifyProductQuantityInCart_Tugba {
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

AutomationExercisePage automationExercisePage=new AutomationExercisePage();
HomePage homePage=new HomePage();
ProductsPage product =new ProductsPage();
    @Test
    public void verify_product_quantity_in_cart(){
        Driver.getDriver().get("http://automationexercise.com");
        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        //4. Click 'View Product' for any product on home page
        automationExercisePage.selectAnyViewProductButtonOnTheHomePage();

        //5. Verify product detail is opened
        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise - Product Details");

        //6. Increase quantity to 4

        automationExercisePage.quantityBox.clear();

        automationExercisePage.quantityBox.sendKeys("4");

        //7. Click 'Add to cart' button
        automationExercisePage.addToCartButton.click();

        //8. Click 'View Cart' button
        automationExercisePage.viewCartButton.click();
    }
}
