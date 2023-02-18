package tests.tests.testCase9_SearchProduct;
import org.openqa.selenium.WebElement;
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

        // 4. Click on 'Products' button
        pageObject.forceToClickIfAdDisplayed(pageObject.productButton);

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise - All Products");

/*      pageObject.searchProductBox.sendKeys("Men");
        pageObject.searchButton.click();  Manually select an item, write it's name into the search box, and search for it. */
        pageObject.selectRandomItemFromAllProductsAndSearchForIt();//Random product selection and searching is automated!

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(pageObject.searchProductsHeader.isDisplayed());

        //8. Verify all the products related to search are visible
        BrowserUtilities.jsScroll(pageObject.brandsInfoColumn);
        int count=1;
        for (WebElement eachSearchResult : pageObject.allSearchResults) {
            BrowserUtilities.hoverOver(eachSearchResult);
            Assert.assertTrue(eachSearchResult.isDisplayed(),count+". search result is hovered. It is not visible");
            System.out.println(count+". search result is hovered. ==> It is visible");
            count++;
        }

        Driver.closeDriver();
    }

}
