package tests.testCase6_ContactUsForm;

import com.google.common.base.Verify;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import testBase.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;

public class TestCase6_ContactUsForm_Bilal extends TestBaseBeforeClassAfterClass {

    @Test
    public void contactUsForm_Test(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        BrowserUtilities.verifyPageTitle(driver,"Automation Exercise");

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        BrowserUtilities.sleep(3);

        //5. Verify 'GET IN TOUCH' is visible
        String getInTouch=driver.findElement(By.xpath("//h2[.='Get In Touch']")).getText();
        Assert.assertEquals(getInTouch,"GET IN TOUCH");

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(faker.chuckNorris().fact());

        //7. Upload file
        driver.findElement(By.xpath("//input[@name='upload_file']")).sendKeys("C:\\Users\\SONY\\Desktop\\cybertruck-official-image.webp");
        BrowserUtilities.sleep(3);

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //9. Click OK button
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String successMessage=driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        System.out.println(successMessage);
        Assert.assertEquals(successMessage,"Success! Your details have been submitted successfully.");

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[.=' Home']")).click();
        BrowserUtilities.verifyPageTitle(driver,"Automation Exercise - Contact Us");




    }
}
