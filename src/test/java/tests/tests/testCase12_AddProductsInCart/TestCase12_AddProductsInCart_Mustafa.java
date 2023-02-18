package tests.tests.testCase12_AddProductsInCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*Test Case 12: Add Products in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price*/
public class TestCase12_AddProductsInCart_Mustafa {


    @Test
    public void testCase12() {
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        pageObject.forceToClickIfAdDisplayed(pageObject.productButton);

        /*5. Hover over first product and click 'Add to cart'
          6. Click 'Continue Shopping' button*/
        BrowserUtilities.jsScroll(pageObject.firstProductBlueTop);
        BrowserUtilities.hoverOver(pageObject.firstProductBlueTop);
        pageObject.hoveredAddCartButton1.click();
        pageObject.continueShoppingButton.click();

        /*7. Hover over second product and click 'Add to cart'
          8. Click 'View Cart' button*/
        BrowserUtilities.jsScroll(pageObject.secondProductMenTShirt);
        BrowserUtilities.hoverOver(pageObject.secondProductMenTShirt);
        pageObject.hoveredAddCartButton2.click();
        pageObject.viewCartButton.click();

        //9. Verify both products are added to Cart
        Assert.assertTrue(pageObject.firstAddedCartItem.isDisplayed());
        Assert.assertTrue(pageObject.secondAddedCartItem.isDisplayed());

        //10. Verify their prices, quantity and total price*/
        for (int i = 3; i < 6; i++) {
            WebElement verifyPriceQuantityTotal = Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[" + i + "]"));
            Assert.assertTrue(verifyPriceQuantityTotal.isDisplayed());
        }

        Driver.getDriver().close();
    }
}
