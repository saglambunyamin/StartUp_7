package tests.tests.testCase7_VerifyTestCasesPage;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

import static tests.base.TestBaseBeforeClassAfterClass.driver;

public class TestCase7_VerifyTestCasesPage_Tugba {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationexercise.com");
    }
    @Test
    public void verify_test_case_7(){
   // 3. Verify that home page is visible successfully
    String actualTitle=driver.getTitle();
    String expectedTitle="Automation Exercise";

    Assert.assertEquals(actualTitle,expectedTitle," Home Page test is FAILED!");
   // 4. Click on 'Test Cases' button

    driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]")).click();


    driver.switchTo().frame("aswift_1");

    driver.findElement(By.id("dismiss-button")).click();




  // driver.switchTo().parentFrame();



    //5. Verify user is navigated to test cases page successfully
        String actualTitleTestCase=driver.getTitle();
        String expectedTitleTestCase="Automation Practice Website for UI Testing - Test Cases";
        Assert.assertEquals(actualTitleTestCase,expectedTitleTestCase,"Test Case title test is Failed! ");


}

}
