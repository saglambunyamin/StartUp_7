package tests.tests.testCase8_VerifyAllProductsAndProductDetailPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TestCase8_VerifyAllProductsAndProductDetailPage_Benjamin {

    @Test
    public void VerifyAllProductsAndProductDetailPageTest () {

        //1. Launch browser
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");

        //4. Click on 'Products' button
        WebElement productsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/products']"));
        productsButton.click();

        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        WebElement adCloseButton = Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']"));
        adCloseButton.click();
        Driver.getDriver().switchTo().parentFrame();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise - All Products");

        //6. The products list is visible
        WebElement productList = Driver.getDriver().findElement(By.xpath("//h2[.='All Products']"));
        Assert.assertTrue(productList.isDisplayed());

        //7. Click on 'View Product' of first product
        WebElement viewProductFirstButton = Driver.getDriver().findElement(By.xpath("//a[@href='/product_details/1']"));
        viewProductFirstButton.click();

        //8. User is landed to product detail page
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise - Product Details");

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = Driver.getDriver().findElement(By.xpath("//h2[.='Blue Top']"));
        WebElement categoryName = Driver.getDriver().findElement(By.xpath("//p[.='Category: Women > Tops']"));
        WebElement price = Driver.getDriver().findElement(By.xpath("//span[.='Rs. 500']"));
        WebElement availability = Driver.getDriver().findElement(By.xpath("//b[.='Availability:']"));
        WebElement condition = Driver.getDriver().findElement(By.xpath("//b[.='Condition:']"));
        WebElement brand = Driver.getDriver().findElement(By.xpath("//b[.='Brand:']"));

        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(categoryName.isDisplayed());
        Assert.assertTrue(price.isDisplayed());
        Assert.assertTrue(availability.isDisplayed());
        Assert.assertTrue(condition.isDisplayed());
        Assert.assertTrue(brand.isDisplayed());

    }

}
