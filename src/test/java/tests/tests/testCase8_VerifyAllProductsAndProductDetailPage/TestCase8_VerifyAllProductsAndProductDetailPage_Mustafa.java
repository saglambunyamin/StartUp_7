package tests.tests.testCase8_VerifyAllProductsAndProductDetailPage;

import org.openqa.selenium.By;
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
    public void testCase7() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        AutomationExercisePage pageObject = new AutomationExercisePage();
        pageObject.productButton.click();

        //Close the ad window
        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        Driver.getDriver().findElement(By.cssSelector("div#dismiss-button")).click();
        Driver.getDriver().switchTo().parentFrame();

        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise - All Products");

        Driver.closeDriver();
    }
}
