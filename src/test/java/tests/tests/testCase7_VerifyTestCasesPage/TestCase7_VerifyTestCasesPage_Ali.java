package tests.tests.testCase7_VerifyTestCasesPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase7_VerifyTestCasesPage_Ali {
    @Test
    public void verifyTestCasesPage_test(){
        ///Test Case 7: Verify Test Cases Page
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        WebElement homePage = Driver.getDriver().findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Test Cases' button
        WebElement testCases=Driver.getDriver().findElement(By.cssSelector("div.item.active div.col-sm-6 a.test_cases_list"));
        testCases.click();


        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        Driver.getDriver().findElement(By.cssSelector("div#dismiss-button")).click();
        Driver.getDriver().switchTo().parentFrame();


        //5. Verify user is navigated to test cases page successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Practice Website for UI Testing - Test Cases");

    }

}
