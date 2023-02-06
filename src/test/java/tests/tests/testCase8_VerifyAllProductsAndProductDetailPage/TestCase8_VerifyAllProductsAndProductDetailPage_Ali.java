package tests.tests.testCase8_VerifyAllProductsAndProductDetailPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase8_VerifyAllProductsAndProductDetailPage_Ali {
    @Test
    public void verifyAllProductsAndProductDetailPage_test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        WebElement homePage = Driver.getDriver().findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Products' button
        WebElement productsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/products']"));
        productsButton.click();

        BrowserUtilities.sleep(2);

        //Pop up (FRAME)
        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).click();
        Driver.getDriver().switchTo().parentFrame();

        BrowserUtilities.sleep(2);

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise - All Products");

        //6. The products list is visible
        WebElement productsList= Driver.getDriver().findElement(By.cssSelector("div.features_items"));
        Assert.assertTrue(productsList.isDisplayed(),"Products list is not visible");

        BrowserUtilities.sleep(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)");

        BrowserUtilities.sleep(2);

        //7. Click on 'View Product' of first product
        WebElement firstViewProduct= Driver.getDriver().findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]"));
        firstViewProduct.click();

        //8. User is landed to product detail page
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise - Product Details");

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand




    }
}
