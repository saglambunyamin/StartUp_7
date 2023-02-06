package tests.tests.testCase9_SearchProduct;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*
Test Case 9: Search Product

    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. Enter product name in search input and click search button
    7. Verify 'SEARCHED PRODUCTS' is visible
    8. Verify all the products related to search are visible

*/
public class TestCase9_SearchProduct_Mustafa {
    @Test
    public void testCase8() {
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        pageObject.productButton.click();

        //Close the ad window
        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        Driver.getDriver().findElement(By.cssSelector("div#dismiss-button")).click();
        Driver.getDriver().switchTo().parentFrame();

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise - All Products");

        pageObject.searchProductBox.sendKeys("bag");
        pageObject.searchButton.click();

        Assert.assertTrue(pageObject.searchProductsHeader.isDisplayed());

        Assert.assertTrue(pageObject.searchResult.isDisplayed());

    }

}
