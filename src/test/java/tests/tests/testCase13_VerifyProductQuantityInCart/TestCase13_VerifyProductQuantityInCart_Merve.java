package tests.tests.testCase13_VerifyProductQuantityInCart;

import com.fasterxml.jackson.databind.ser.std.ClassSerializer;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.Driver.getDriver;

public class TestCase13_VerifyProductQuantityInCart_Merve {
    ///*Test Case 13: Verify Product quantity in Cart
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully


    @Test
    public void testcase13() {
        getDriver().get(ConfigurationReader.getProperty("env"));
        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise");
        //4. Click 'View Product' for any product on home page
        AutomationExercisePage automationExercisePage = new AutomationExercisePage();
        automationExercisePage.selectAnyViewProductButtonOnTheHomePage();
        //5. Verify product detail is opened
        automationExercisePage.verifyAllProductDetailsVisibility();

        //6. Increase quantity to 4

        BrowserUtilities.getActions().click(automationExercisePage.quantityBox).
                sendKeys(Keys.CLEAR).
                sendKeys("4").perform();

        //7. Click 'Add to cart' button
        automationExercisePage.addToCartButton.click();
        //8. Click 'View Cart' button
        automationExercisePage.viewCartButton.click();
        //9. Verify that product is displayed in cart page with exact quantity*/
       // Assert.assertEquals(automationExercisePage.productQuantityBoxInCart.getText(),4);
        //}


    }


}

