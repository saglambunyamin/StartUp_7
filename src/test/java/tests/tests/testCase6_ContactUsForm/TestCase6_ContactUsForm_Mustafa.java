package tests.tests.testCase6_ContactUsForm;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBaseBeforeClassAfterClass;
import utilities.ConfigurationReader;
/*Test Case 6: Contact Us Form
testCase6_ContactUsForm
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully*/
public class TestCase6_ContactUsForm_Mustafa extends TestBaseBeforeClassAfterClass {
    Faker faker=new Faker();
    String userName = faker.name().username();
    String massage = faker.chuckNorris().fact()+" "+faker.chuckNorris().fact()+" "+faker.chuckNorris().fact();
    String subject = faker.chuckNorris().fact();
    String emailAddress=faker.internet().emailAddress();
    @Test()
    public void test1() {
        driver.get(ConfigurationReader.getProperty("env"));

        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Home page is not visible successfully.");

        //Click on 'Contact Us' button, fill the related parts
        driver.findElement(By.cssSelector("i.fa.fa-envelope")).click();

        WebElement nameBox = driver.findElement(By.cssSelector("input[name='name']"));
        actions.click(nameBox).sendKeys(userName)
                .sendKeys(Keys.TAB)
                .sendKeys(emailAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(subject.replaceAll("Chuck Norris","Mustafa"))
                .sendKeys(Keys.TAB)
                .sendKeys(massage.replaceAll("Chuck Norris","Mustafa"))
                .sendKeys(Keys.TAB).perform();
        //Upload a file
        WebElement chooseFileButton= driver.findElement(By.cssSelector("input[name=\"upload_file\"]"));
        String path = "/Users/mustafacetinkaya/Desktop/collections.png";
        chooseFileButton.sendKeys(path);

        WebElement submitButton= driver.findElement(By.cssSelector("input[name='submit']"));
        submitButton.submit();

        //Click on the ok button
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //Verify the given text
        WebElement successMessage= driver.findElement(By.cssSelector("div.status.alert.alert-success"));
        Assert.assertEquals(successMessage.getText(),"Success! Your details have been submitted successfully.");

        //Go to the homepage
        driver.findElement(By.cssSelector("i.fa.fa-home")).click();
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Contact Us", "Home page is not visible successfully.");

    }
}
