package tests.tests.testCase9_SearchProduct;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import pages.DarknessPages.SearchProductPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase9_SearchProduct_Ali {
    @Test
    public void testCase9_SearchProduct_test(){

        //Test Case 9: Search Product
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        SearchProductPage pageObject=new SearchProductPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Click on 'Products' button

        BrowserUtilities.closeAdPage_afterHomePage(pageObject.productsButton);


        //5. Verify user is navigated to ALL PRODUCTS page successfully
        BrowserUtilities.jsScroll(pageObject.allProducts);
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise - All Products");



        //6. Enter product name in search input and click search button
        pageObject.searchProductBox.sendKeys("Dress");
        pageObject.searchButton.click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(pageObject.searchedProducts.isDisplayed(),"SEARCHED PRODUCTS is not visible");

        //8. Verify all the products related to search are visible

        pageObject.verifyAllTheProductsRelatedToSearch();



    }
}
