package tests.testCase7_VerifyTestCasesPage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import reusableMethods.AutomationExercisePage;
import reusableMethods.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

/*Test Case 7: Verify Test Cases Page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully*/
public class TestCase7_VerifyTestCasesPage_Mustafa {
    @Test
    public void testCase7() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        BrowserUtilities.verifyPageTitle(Driver.getDriver(), "Automation Exercise");

        AutomationExercisePage pageObject = new AutomationExercisePage();
        pageObject.testCasesButton.click();

        //Close the goddamn ad window
        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        Driver.getDriver().findElement(By.cssSelector("div#dismiss-button")).click();
        Driver.getDriver().switchTo().parentFrame();

        BrowserUtilities.verifyPageTitle(Driver.getDriver(),"Automation Practice Website for UI Testing - Test Cases");
    }
}
