package tests.tests.testCase7_VerifyTestCasesPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TestCase7_VerifyTestCasesPage_Merve {
    /*Test Case 7: Verify Test Cases Page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully*/
@Test
    public  void testcase7(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    //3. Verify that home page is visible successfully
    Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");
    //4. Click on 'Test Cases' button
    WebElement testCasesButton = Driver.getDriver().findElement(By.xpath("(//a[@href='/test_cases']) [1]"));
    testCasesButton.click();
    Driver.getDriver().switchTo().frame("aswift_5");
    Driver.getDriver().switchTo().frame("ad_iframe");
    Driver.getDriver().findElement(By.cssSelector("div#dismiss-button")).click();
    Driver.getDriver().switchTo().parentFrame();



    //5. Verify user is navigated to test cases page successfully
    Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Practice Website for UI Testing - Test Cases");

    }
}
