package tests.tests.testCase17;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*Test Case 17: Remove Products From Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart*/
public class TestCase17_RemoveProductsFromCart_Mustafa {

int numberOfElementInCartBeforeDeleting;
int numberOfElementInCartAfterDeleting;


    @Test
    public void testCase17() {
        /*1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully*/
        AutomationExercisePage pageObject = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        pageObject.closeAdWindowByCheckingPageTitle("Automation Exercise");

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        //4. Add products to cart randomly with given quantity
        pageObject.addItemWithGivenQuantity(3);

        //5. Click 'Cart' button
        BrowserUtilities.jsScrollClick(pageObject.cartButton);

        //6. Verify that cart page is displayed
        pageObject.verifyThatCartPageIsDisplayed();

        //7. Click 'X' button corresponding to particular product
        numberOfElementInCartBeforeDeleting=pageObject.numberOfItemsInCart.size();
        pageObject.deleteFirstItemsInCart.click();
        numberOfElementInCartAfterDeleting=pageObject.numberOfItemsInCart.size();

        //8. Verify that product is removed from the cart
        Assert.assertFalse(numberOfElementInCartAfterDeleting!=numberOfElementInCartBeforeDeleting);

        Driver.closeDriver();
    }
}
