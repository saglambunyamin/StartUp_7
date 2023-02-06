package tests.tests.testCase5_RegisterUserWithExistingEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TestCase5_RegisterUserWithExistingEmail_Benjamin {

    @Test
    public void RegisterAccount () {
        Driver.getDriver().get("http://automationexercise.com");

        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//a[.=' Signup / Login']"));
        signUpButton.click();

        WebElement nameInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        nameInputBox.sendKeys("Benjamin Strong");

        WebElement emailInputBox = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailInputBox.sendKeys("benjamins@email.com");

        WebElement signUpBtn = Driver.getDriver().findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpBtn.click();

        WebElement genderType = Driver.getDriver().findElement(By.xpath("//input[@id='id_gender1']"));
        genderType.click();

        WebElement passwordInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        passwordInputBox.sendKeys("benjamin");

        Select dayDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='days']")));
        dayDropdown.selectByValue("2");

        Select monthDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='months']")));
        monthDropdown.selectByVisibleText("October");

        Select yearDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='years']")));
        yearDropdown.selectByValue("1985");

        WebElement checkBox1 = Driver.getDriver().findElement(By.xpath("//input[@id='newsletter']"));
        checkBox1.click();

        WebElement checkBox2 = Driver.getDriver().findElement(By.xpath("//input[@id='optin']"));
        checkBox2.click();

        WebElement firstNameInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='first_name']"));
        firstNameInputBox.sendKeys("Benjamin");

        WebElement lastNameInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='last_name']"));
        lastNameInputBox.sendKeys("Strong");

        WebElement companyInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='company']"));
        companyInputBox.sendKeys("Bs Co");

        WebElement address1InputBox = Driver.getDriver().findElement(By.xpath("//input[@id='address1']"));
        address1InputBox.sendKeys("Northeast 44");

        Select countryDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='country']")));
        countryDropdown.selectByVisibleText("United States");

        WebElement stateInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='state']"));
        stateInputBox.sendKeys("NY");

        WebElement cityInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='city']"));
        cityInputBox.sendKeys("New York");

        WebElement zipCodeInputBox = Driver.getDriver().findElement(By.xpath("//input[@id='zipcode']"));
        zipCodeInputBox.sendKeys("10014");

        WebElement mobileNumber = Driver.getDriver().findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNumber.sendKeys("485-8242168");

        WebElement createAccountButton = Driver.getDriver().findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountButton.click();

        WebElement accountCreatedMessage = Driver.getDriver().findElement(By.xpath("//b[.='Account Created!']"));
        Assert.assertEquals(accountCreatedMessage.getText(), "ACCOUNT CREATED!");
    }

    @Test
    public void RegisterUserWithExistingEmailTest() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");

        //4. Click on 'Signup / Login' button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//a[.=' Signup / Login']"));
        signUpButton.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignupText = Driver.getDriver().findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertEquals(newUserSignupText.getText(), "New User Signup!");

        //6. Enter name and already registered email address
        WebElement nameInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        nameInputBox.sendKeys("Benjamin Strong");

        WebElement emailInputBox = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailInputBox.sendKeys("benjamins@email.com");

        //7. Click 'Signup' button
        WebElement signUpBtn = Driver.getDriver().findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpBtn.click();

        //8. Verify error 'Email Address already exist!' is visible
        WebElement verifyErrorMessage = Driver.getDriver().findElement(By.xpath("//p[.='Email Address already exist!']"));
        Assert.assertEquals(verifyErrorMessage.getText(), "Email Address already exist!");


    }

}
