package tests.tests.testCase8_VerifyAllProductsAndProductDetailPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.Driver.getDriver;

public class TestCase8_VerifyAllProductsAndProductDetailPage_Merve {
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
    @Test
    public void testcase8() {
        getDriver().get(ConfigurationReader.getProperty("env"));
        //3. Verify that home page is visible successfully
        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise");

        //4. Click on 'Products' button
        WebElement productsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/products']"));
        productsButton.click();
        Driver.getDriver().navigate().refresh();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise - All Products");
        //6. The products list is visible
        WebElement productList = Driver.getDriver().findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productList.isDisplayed());

        //7. Click on 'View Product' of first product
        Driver.getDriver().findElement(By.xpath("//a[@href='/product_details/1']")).click();

        //8. User is landed to product detail page
        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise - Product Details");

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = Driver.getDriver().findElement(By.xpath("//h2[.='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());
        WebElement category = Driver.getDriver().findElement(By.xpath("//p[.='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price = Driver.getDriver().findElement(By.xpath("//span[.='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        WebElement availability = Driver.getDriver().findElement(By.xpath("//b[.='Availability:']"));
        Assert.assertTrue(availability.isDisplayed());
        WebElement condition = Driver.getDriver().findElement(By.xpath("//b[.='Condition:']"));
        Assert.assertTrue(condition.isDisplayed());
        WebElement brand = Driver.getDriver().findElement(By.xpath("//b[.='Brand:']"));
        Assert.assertTrue(brand.isDisplayed());
        //
    }
}
