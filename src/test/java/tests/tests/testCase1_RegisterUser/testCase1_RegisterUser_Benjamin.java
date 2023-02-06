package tests.tests.testCase1_RegisterUser;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class testCase1_RegisterUser_Benjamin {

    @Test
    public void RegisterUserTest () {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");

        //4. Click on 'Signup / Login' button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//a[.=' Signup / Login']"));
        signUpButton.click();

        //5. Verify 'Sign up / Login' is visible
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Signup / Login"));

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignupText = Driver.getDriver().findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertEquals(newUserSignupText.getText(), "New User Signup!");

        Faker faker = new Faker();

        //6. Enter name and email address
        WebElement nameInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        nameInputBox.sendKeys(faker.name().fullName());

        WebElement emailInputBox = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailInputBox.sendKeys(faker.name().username() + "@email.com");

        //7. Click 'Signup' button
        WebElement signUpBtn = Driver.getDriver().findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpBtn.click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement signUpVerifyText = Driver.getDriver().findElement(By.xpath("//b[.='Enter Account Information']"));
        Assert.assertEquals(signUpVerifyText.getText(), "ENTER ACCOUNT INFORMATION");

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement genderType = Driver.getDriver().findElement(By.xpath("//input[@id='id_gender1']"));
        genderType.click();

        WebElement passwordInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        passwordInputBox.sendKeys(faker.bothify("##??#?#?"));

        Select dayDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='days']")));
        dayDropdown.selectByValue("2");

        Select monthDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='months']")));
        monthDropdown.selectByVisibleText("October");

        Select yearDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='years']")));
        yearDropdown.selectByValue("1985");

        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkBox1 = Driver.getDriver().findElement(By.xpath("//input[@id='newsletter']"));
        checkBox1.click();

        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkBox2 = Driver.getDriver().findElement(By.xpath("//input[@id='optin']"));
        checkBox2.click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='first_name']"));
        firstNameInputBox.sendKeys(faker.name().firstName());

        WebElement lastNameInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='last_name']"));
        lastNameInputBox.sendKeys(faker.name().lastName());

        WebElement companyInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='company']"));
        companyInputBox.sendKeys(faker.company().name());

        WebElement address1InputBox = Driver.getDriver().findElement(By.xpath("//input[@id='address1']"));
        address1InputBox.sendKeys(faker.address().fullAddress());

        Select countryDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='country']")));
        countryDropdown.selectByVisibleText("United States");

        WebElement stateInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='state']"));
        stateInputBox.sendKeys(faker.address().state());

        WebElement cityInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='city']"));
        cityInputBox.sendKeys(faker.address().city());

        WebElement zipCodeInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='zipcode']"));
        zipCodeInputBox.sendKeys(faker.address().zipCode());

        WebElement mobileNumber = Driver.getDriver().findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNumber.sendKeys(faker.phoneNumber().cellPhone());

        //13. Click 'Create Account button'
        WebElement createAccountButton = Driver.getDriver().findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountButton.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedMessage = Driver.getDriver().findElement(By.xpath("//b[.='Account Created!']"));
        Assert.assertEquals(accountCreatedMessage.getText(), "ACCOUNT CREATED!");

        //15. Click 'Continue' button
        WebElement continueButton = Driver.getDriver().findElement(By.xpath("//a[.='Continue']"));
        continueButton.click();

        Driver.getDriver().switchTo().frame("aswift_2");
        Driver.getDriver().switchTo().frame("ad_iframe");
        WebElement adCloseButton = Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']"));
        adCloseButton.click();
        Driver.getDriver().switchTo().parentFrame();

        //16. Verify that 'Logged in as username' is visible
        WebElement loggedMessage = Driver.getDriver().findElement(By.xpath("(//li//a) [1]"));
        Assert.assertTrue(loggedMessage.isDisplayed());

        //17. Click 'Delete Account' button
        WebElement deleteAccountButton = Driver.getDriver().findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccountButton.click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedMessage = Driver.getDriver().findElement(By.xpath("//h2//b"));
        Assert.assertTrue(accountDeletedMessage.isDisplayed());

        WebElement continueBtn = Driver.getDriver().findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueBtn.click();

        Driver.getDriver().quit();

    }

}