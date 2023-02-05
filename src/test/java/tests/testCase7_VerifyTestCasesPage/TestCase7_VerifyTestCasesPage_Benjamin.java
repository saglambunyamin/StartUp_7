package tests.testCase7_VerifyTestCasesPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TestCase7_VerifyTestCasesPage_Benjamin {

    @Test
    public void VerifyTestCasesPageTest () {

        //1. Launch browser
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");

        //4. Click on 'Test Cases' button
        WebElement testCasesButton = Driver.getDriver().findElement(By.xpath("(//a[@href='/test_cases']) [1]"));
        testCasesButton.click();

        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        WebElement adCloseButton = Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']"));
        adCloseButton.click();
        Driver.getDriver().switchTo().parentFrame();

        //5. Verify user is navigated to test cases page successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Practice Website for UI Testing - Test Cases");

    }

}
