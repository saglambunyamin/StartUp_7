package tests.tests.testCase9_SearchProduct;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyPages_Bilal.HomePage;
import pages.MyPages_Bilal.ProductsPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;


public class TestCase9_SearchProduct_Bilal {

    @Test
    public void TestCase9_SearchProduct_Test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //    4. Click on 'Products' button
        HomePage homePage= new HomePage();
        homePage.productsButton.click();
        BrowserUtilities.sleep(3);
        homePage.closeAdPage_AfterHomePage2();

        //    5. Verify user is navigated to ALL PRODUCTS page successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise - All Products");

        //    6. Enter product name in search input and click search button
        ProductsPage productsPage=new ProductsPage();
        productsPage.searchPruduct.sendKeys("Top");
        productsPage.searchButton.click();

        //    7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertEquals(productsPage.searchedProductsText.getText(),"SEARCHED PRODUCTS");

        //    8. Verify all the products related to search are visible

        List<WebElement> list=Driver.getDriver().findElements(By.xpath("//p[contains(.,'Top')]"));


        for (WebElement element : ProductsPage.topList) {
            System.out.println(element.getText()+" is visible");
        }

        Driver.closeDriver();
    }
}
