package tests.testCase6_ContactUsForm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import reusableMethods.AutomationExercisePage;
import reusableMethods.BrowserUtilities;
import utilities.ConfigurationReader;

public class TestFindBy extends AutomationExercisePage {
    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("env"));

        homeButton.click();
        BrowserUtilities.sleep(3);

        signupLoginButton.click();
        driver.navigate().back();
        BrowserUtilities.sleep(3);

        chartButton.click();
        driver.navigate().back();
        BrowserUtilities.sleep(3);

        productButton.click();
        driver.navigate().back();
        BrowserUtilities.sleep(3);

        testCasesButton.click();
        driver.navigate().back();
        BrowserUtilities.sleep(3);

        apiTestingButton.click();
        driver.navigate().back();
        BrowserUtilities.sleep(3);

        videoTutorialsButton.click();
        driver.navigate().back();
        BrowserUtilities.sleep(3);

        contactUsButton.click();
        driver.navigate().back();
        BrowserUtilities.sleep(3);

    }
}
