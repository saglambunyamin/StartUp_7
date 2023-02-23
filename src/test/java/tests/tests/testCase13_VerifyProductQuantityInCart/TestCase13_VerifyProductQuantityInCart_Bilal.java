package tests.tests.testCase13_VerifyProductQuantityInCart;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import pages.MyPages_Bilal.HomePage;
import pages.MyPages_Bilal.ProductDetailPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Random;

public class TestCase13_VerifyProductQuantityInCart_Bilal {

    @Test
    public void VerifyProductQuantityInCart_Test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Click 'View Product' for any product on home page
        new AutomationExercisePage().selectAnyViewProductButtonOnTheHomePage();
        /*
        Random random=new Random();
        HomePage homePage=new HomePage();
        Actions actions=new Actions(Driver.getDriver());
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

        int randomElement = random.nextInt(homePage.viewProductButtons.size());
        WebElement currentViewPruductButton=homePage.viewProductButtons.get(randomElement);

        js.executeScript("arguments[0].scrollIntoView(true);", currentViewPruductButton);
        BrowserUtilities.sleep(2);
        actions.moveToElement(currentViewPruductButton).pause(2000).click().perform();
        BrowserUtilities.sleep(2);

        Driver.getDriver().navigate().refresh();
        BrowserUtilities.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true);", currentViewPruductButton);
        BrowserUtilities.sleep(2);
        actions.moveToElement(currentViewPruductButton).pause(2000).click().perform();

         */

        //5. Verify product detail is opened
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Product Details"));

        //6. Increase quantity to 4
        ProductDetailPage productDetailPage= new ProductDetailPage();
        Actions actions=new Actions(Driver.getDriver());

        actions.moveToElement(productDetailPage.productQuantity).doubleClick().sendKeys(Keys.DELETE).
                pause(2000).sendKeys(4+"").pause(2000).sendKeys(Keys.ENTER);



        //7. Click 'Add to cart' button


        //8. Click 'View Cart' button


        //9. Verify that product is displayed in cart page with exact quantity


    }


}
