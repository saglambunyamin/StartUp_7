package tests.tests.testCase9_SearchProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.Driver.getDriver;

public class TestCase9_SearchProduct_Merve {
    ///*
    //Test Case 9: Search Product
    //
    //    1. Launch browser
    //    2. Navigate to url 'http://automationexercise.com'
    //    3. Verify that home page is visible successfully
    @Test
    public void testcase9() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        //3. Verify that home page is visible successfully
        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise");

        //4. Click on 'Products' button
        WebElement productsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/products']"));
        productsButton.click();
        Driver.getDriver().navigate().refresh();
        //    5. Verify user is navigated to ALL PRODUCTS page successfully
        //System.out.println(getDriver().getTitle());
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise - All Products");
        //    6. Enter product name in search input and click search button
        Driver.getDriver().findElement(By.xpath("//input[.='Search Product']"));

        //    7. Verify 'SEARCHED PRODUCTS' is visible
        //    8. Verify all the products related to search are visible
        //
        //*/
        //
    }
}