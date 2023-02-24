package tests.tests.testCase14_PlaceOrderRegisterWhileCheckout;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import pages.MyPages_Bilal.HomePage;
import pages.MyPages_Bilal.ProductsPage;
import pages.MyPages_Bilal.View_cartPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Random;

public class TestCase14_PlaceOrderRegisterWhileCheckout_Bilal {

    @Test
    public void PlaceOrderRegisterWhileCheckout_Test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Add products to cart
        HomePage homePage=new HomePage();
        for (int i = 1; i < 4; i++) {
            //int randomNumber = BrowserUtilities.random().nextInt(homePage.viewProductButtons.size());
            WebElement randomAddtoCart = Driver.getDriver().findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])["+i+"]"));
            BrowserUtilities.clickWithJS(randomAddtoCart);
            homePage.continueShoppingButton.click();
        }

            //5. Click 'Cart' button
        AutomationExercisePage pageObject=new AutomationExercisePage();
        pageObject.safeClickByCheckingThePageTitle(homePage.cartButton, "Automation Exercise");

        //6. Verify that cart page is displayed

            //7. Click Proceed To Checkout

            //8. Click 'Register / Login' button

            //9. Fill all details in Signup and create account
            //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            //11. Verify ' Logged in as username' at top
            //12.Click 'Cart' button
            //13. Click 'Proceed To Checkout' button
            //14. Verify Address Details and Review Your Order
            //15. Enter description in comment text area and click 'Place Order'
            //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            //17. Click 'Pay and Confirm Order' button
            //18. Verify success message 'Your order has been placed successfully!'
            //19. Click 'Delete Account' button
            //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button


        }
}
