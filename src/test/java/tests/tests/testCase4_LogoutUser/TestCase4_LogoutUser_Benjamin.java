package tests.tests.testCase4_LogoutUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TestCase4_LogoutUser_Benjamin {

    @Test
    public void BeforeLogin () {
        Driver.getDriver().get("http://automationexercise.com");

        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//a[.=' Signup / Login']"));
        signUpButton.click();

        WebElement nameInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        nameInputBox.sendKeys("Benjamin Strong");

        WebElement emailInputBox = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailInputBox.sendKeys("benjaminstrong@email.com");

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
    public void LogoutUserTest () {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise");

        //4. Click on 'Signup / Login' button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//a[.=' Signup / Login']"));
        signUpButton.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountText = Driver.getDriver().findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertEquals(loginToYourAccountText.getText(),"Login to your account");

        //6. Enter correct email address and password
        WebElement emailInputBox = Driver.getDriver().findElement(By.xpath("//input[@data-qa='login-email']"));
        emailInputBox.sendKeys("benjaminstrong@email.com");

        WebElement passwordInputBox = Driver.getDriver().findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordInputBox.sendKeys("benjamin");

        //7. Click 'login' button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedMessage = Driver.getDriver().findElement(By.xpath("(//li//a) [1]"));
        Assert.assertTrue(loggedMessage.isDisplayed());

        //9. Click 'Logout' button
        WebElement LogOutButton = Driver.getDriver().findElement(By.xpath("//a[@href='/logout']"));
        LogOutButton.click();

        //10. Verify that user is navigated to login page
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise - Signup / Login");

    }
}
