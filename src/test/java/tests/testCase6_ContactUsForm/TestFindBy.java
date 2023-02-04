package tests.testCase6_ContactUsForm;
import org.testng.annotations.Test;
import reusableMethods.AutomationExercisePage;
import reusableMethods.BrowserUtilities;
import utilities.ConfigurationReader;

public class TestFindBy {

    AutomationExercisePage pageObject=new AutomationExercisePage();
    @Test
    public void test(){
        pageObject.driver.get(ConfigurationReader.getProperty("env"));

        pageObject.homeButton.click();
        BrowserUtilities.sleep(3);

        pageObject.signupLoginButton.click();
        pageObject.driver.navigate().back();
        BrowserUtilities.sleep(3);

        pageObject.chartButton.click();
        pageObject.driver.navigate().back();
        BrowserUtilities.sleep(3);

        pageObject.productButton.click();
        pageObject.driver.navigate().back();
        BrowserUtilities.sleep(3);

        pageObject.testCasesButton.click();
        pageObject.driver.navigate().back();
        BrowserUtilities.sleep(3);

        pageObject.apiTestingButton.click();
        pageObject.driver.navigate().back();
        BrowserUtilities.sleep(3);

        pageObject.videoTutorialsButton.click();
        pageObject.driver.navigate().back();
        BrowserUtilities.sleep(3);

        pageObject.contactUsButton.click();
        pageObject.driver.navigate().back();
        BrowserUtilities.sleep(3);

    }
}
