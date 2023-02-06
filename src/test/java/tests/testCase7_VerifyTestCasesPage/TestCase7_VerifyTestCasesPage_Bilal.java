package tests.testCase7_VerifyTestCasesPage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase7_VerifyTestCasesPage_Bilal {


    @Test
    public void VerifyTestCasesPage_Test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Exercise");

        //4. Click on 'Test Cases' button
        Driver.getDriver().findElement(By.xpath("//div[@class='item active']/div/a/button")).click();
        BrowserUtilities.sleep(2);

        //5. Verify user is navigated to test cases page successfully
        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).click();
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Practice Website for UI Testing - Test Cases");

        Driver.closeDriver();




    }

}
