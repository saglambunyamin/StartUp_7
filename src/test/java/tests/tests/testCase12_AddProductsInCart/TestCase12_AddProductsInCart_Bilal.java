package tests.tests.testCase12_AddProductsInCart;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MyPages_Bilal.HomePage;
import pages.MyPages_Bilal.ProductsPage;
import pages.MyPages_Bilal.View_cartPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase12_AddProductsInCart_Bilal {

    @Test
    public void AddProductsInCart_Test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //    4. Click on 'Products' button
        HomePage homePage= new HomePage();
        homePage.click_and_closeAdPage_AfterHomePage(homePage.productsButton);

        //5. Hover over first product and click 'Add to cart'
        //6. Click 'Continue Shopping' button
        ProductsPage productsPage=new ProductsPage();

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(productsPage.firstProduct).pause(2000).click().perform();
        productsPage.continueShoppingButton.click();


        //7. Hover over second product and click 'Add to cart'
        actions.moveToElement(productsPage.secondProduct).pause(2000).click().perform();

        //8. Click 'View Cart' button
        productsPage.viewCartButton.click();

        //9. Verify both products are added to Cart
        View_cartPage view_cartPage=new View_cartPage();
        view_cartPage.assertWebTableElements(1,2,2,2);

        //10. Verify their prices, quantity and total price
        view_cartPage.assertWebTableElements(1,2,3,5);
    }

}
