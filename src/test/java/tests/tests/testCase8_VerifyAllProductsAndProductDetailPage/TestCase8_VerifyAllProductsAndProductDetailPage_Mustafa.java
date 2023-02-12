package tests.tests.testCase8_VerifyAllProductsAndProductDetailPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*Test Case 8: Verify All Products and product detail page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail is visible: product name, category, price, availability, condition, brand
*/
public class TestCase8_VerifyAllProductsAndProductDetailPage_Mustafa {
    @Test
    public void testCase8() {
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        pageObject.productButton.click();

        //Close the ad window
        pageObject.closeAdWindow();

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise - All Products");

        //7. Click on 'View Product' of first product
        BrowserUtilities.jsScrollClick(pageObject.viewProductBlueTop);

        //8. User is landed to product detail page
        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise - Product Details");

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        pageObject.verifySelectedProductDetailsVisibility();

        Driver.closeDriver();
    }
}
