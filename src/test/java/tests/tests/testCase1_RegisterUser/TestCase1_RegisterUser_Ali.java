package tests.tests.testCase1_RegisterUser;

        import com.github.javafaker.Faker;
        import org.openqa.selenium.*;
        import org.openqa.selenium.support.ui.Select;
        import org.testng.annotations.Test;
        import utilities.BrowserUtilities;
        import utilities.ConfigurationReader;
        import utilities.Driver;

public class TestCase1_RegisterUser_Ali {
    @Test(priority = 1)
    public void testCase1_RegisterUser_test() {
        //Test Case 1: Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully

        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();
        //Assert.assertEquals(actualTitle,expectedTitle);
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Home page is visible");
        } else {
            System.out.println("Home page is not visible");
        }

        //4. Click on 'Signup / Login' button
        WebElement signupLoginButton = Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton.click();
        BrowserUtilities.sleep(1);

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignupTxt = Driver.getDriver().findElement(By.xpath("//h2[.='New User Signup!']"));
        if (newUserSignupTxt.isDisplayed()) {
            System.out.println("New User Signup! is visible");
        } else {
            System.out.println("New User Signup! is not visible");
        }
/*
        String expectedNewUserSignupTxt="New User Signup!";
        String actualNewUserSignupTxt=newUserSignupTxt.getText();
        if (actualNewUserSignupTxt.equals(expectedNewUserSignupTxt)){
            System.out.println("New User Signup! is visible");
        }else{
            System.out.println("New User Signup! is not visible");
        }

 */

        //6. Enter name and email address
        Faker faker = new Faker();
        WebElement nameBox = Driver.getDriver().findElement(By.xpath("//input[@name='name']"));
        String userName = faker.name().username();
        //String userName ="ali.karanlik";
        nameBox.sendKeys(userName);

        BrowserUtilities.sleep(1);

        WebElement emailAddressBox = Driver.getDriver().findElement(By.xpath("(//input[@type='email'])[2]"));
        //String emailAddress = "cydeo06@gmail.com";
        String emailAddress =faker.internet().emailAddress();
        emailAddressBox.sendKeys(emailAddress);
        BrowserUtilities.sleep(1);

        //7. Click 'Signup' button
        WebElement signupButton = Driver.getDriver().findElement(By.xpath("//button[.='Signup']"));
        signupButton.click();
        BrowserUtilities.sleep(1);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformation = Driver.getDriver().findElement(By.xpath("//b[.='Enter Account Information']"));
        if (enterAccountInformation.isDisplayed()) {
            System.out.println("ENTER ACCOUNT INFORMATION is visible");
        } else {
            System.out.println("ENTER ACCOUNT INFORMATION is not visible");

        }

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement titleGender = Driver.getDriver().findElement(By.cssSelector("input#id_gender1"));
        titleGender.click();
        BrowserUtilities.sleep(1);
        /*

        WebElement accountName = Driver.getDriver().findElement(By.xpath("//input[@id='name']"));
        accountName.clear();
        BrowserUtilities.sleep(1);
        accountName.sendKeys(faker.name().firstName());
        BrowserUtilities.sleep(1);

        WebElement accountEmail = Driver.getDriver().findElement(By.xpath("//input[@id='email']"));
       // accountEmail.sendKeys(faker.internet().emailAddress());
        System.out.println("accountEmail.isEnabled() = " + accountEmail.isEnabled());
        BrowserUtilities.sleep(1);

        */
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2000)");

        WebElement accountPassword = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        accountPassword.sendKeys(faker.internet().password());
        //String password = "12345";
        //accountPassword.sendKeys(password);
        BrowserUtilities.sleep(1);

        Select selectDayDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='days']")));
        selectDayDropdown.selectByValue(faker.number().numberBetween(1, 31) + "");
        BrowserUtilities.sleep(1);

        Select selectMonthDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='months']")));
        selectMonthDropdown.selectByValue(faker.number().numberBetween(1, 12) + "");
        BrowserUtilities.sleep(1);

        Select selectYearDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='years']")));
        selectYearDropdown.selectByValue(faker.number().numberBetween(1900, 2021) + "");
        BrowserUtilities.sleep(1);

        //10. Select checkbox 'Sign up for our newsletter!'

        WebElement signUpForOurNewsletterBox = Driver.getDriver().findElement(By.xpath("//label[.='Sign up for our newsletter!']"));
        BrowserUtilities.sleep(1);
        signUpForOurNewsletterBox.click();
        BrowserUtilities.sleep(1);

        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement receiveSpecialOffersFromOurPartnersBox = Driver.getDriver().findElement(By.xpath("//label[.='Receive special offers from our partners!']"));
        BrowserUtilities.sleep(1);

        receiveSpecialOffersFromOurPartnersBox.click();
        BrowserUtilities.sleep(1);

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameBox = Driver.getDriver().findElement(By.xpath("//input[@id='first_name']"));
        firstNameBox.sendKeys(faker.name().firstName());
        BrowserUtilities.sleep(1);

        WebElement lastNameBox = Driver.getDriver().findElement(By.xpath("//input[@id='last_name']"));
        lastNameBox.sendKeys(faker.name().lastName());
        BrowserUtilities.sleep(1);

        WebElement companyNameBox = Driver.getDriver().findElement(By.xpath("//input[@id='company']"));
        companyNameBox.sendKeys("CYDEO");
        BrowserUtilities.sleep(1);

        WebElement address1 = Driver.getDriver().findElement(By.xpath("//input[@id='address1']"));
        address1.sendKeys(faker.address().fullAddress());
        BrowserUtilities.sleep(1);

        WebElement address2 = Driver.getDriver().findElement(By.xpath("//input[@id='address2']"));
        address2.sendKeys(faker.address().fullAddress());
        BrowserUtilities.sleep(1);

        Select selectCountryDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='country']")));
        selectCountryDropdown.selectByIndex(faker.number().numberBetween(0, 6));
        BrowserUtilities.sleep(1);


        WebElement stateBox = Driver.getDriver().findElement(By.xpath("//input[@id='state']"));
        stateBox.sendKeys(faker.address().state());

        BrowserUtilities.sleep(2);
        js.executeScript("window.scrollBy(0,300)");
        BrowserUtilities.sleep(2);

        WebElement cityBox = Driver.getDriver().findElement(By.xpath("//input[@id='city']"));
        cityBox.sendKeys(faker.address().city());
        BrowserUtilities.sleep(1);

        WebElement zipcodeBox = Driver.getDriver().findElement(By.xpath("//input[@id='zipcode']"));
        zipcodeBox.sendKeys(faker.address().zipCode());
        BrowserUtilities.sleep(1);

        WebElement mobileNumberBox = Driver.getDriver().findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNumberBox.sendKeys(faker.phoneNumber().cellPhone());
        BrowserUtilities.sleep(1);

        //13. Click 'Create Account button'
        WebElement createAccountButton = Driver.getDriver().findElement(By.xpath("(//button[@type='submit'])[1]"));
        createAccountButton.click();
        BrowserUtilities.sleep(1);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement isVisibleAccountCreated = Driver.getDriver().findElement(By.tagName("b"));
        if (isVisibleAccountCreated.isDisplayed()) {
            System.out.println("ACCOUNT CREATED! is visible");
        } else {
            System.out.println("ACCOUNT CREATED! is not visible");

        }

        //15. Click 'Continue' button
        WebElement continueButton = Driver.getDriver().findElement(By.xpath("//a[.='Continue']"));
        continueButton.click();
        BrowserUtilities.sleep(1);


        Driver.getDriver().switchTo().frame("aswift_2");
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.cssSelector("div.creative>iframe")));
        Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).click();
        Driver.getDriver().switchTo().parentFrame();


        //16. Verify that 'Logged in as username' is visible
        WebElement isVisibleLoggedInAs = Driver.getDriver().findElement(By.tagName("b"));
        if (isVisibleLoggedInAs.isDisplayed()) {
            System.out.println("Logged in as username is visible");
        } else {
            System.out.println("Logged in as username is not visible");
        }
        //17. Click 'Delete Account' button
        WebElement deleteAccountButton = Driver.getDriver().findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccountButton.click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement isVisibleAccountDeleted = Driver.getDriver().findElement(By.xpath("//b[contains(text(),'Account Deleted!')]"));
        if (isVisibleAccountDeleted.isDisplayed()) {
            System.out.println("ACCOUNT DELETED! is visible");
        } else {
            System.out.println("ACCOUNT DELETED! is not visible");
        }

    }


    @Test(priority = 2)
    public void loginUserWithCorrectEmailAndPassword_test() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        //3. Verify that home page is visible successfully
        String expectedTitle2="Automation Exercise";
        String actualTitle2 = Driver.getDriver().getTitle();
        //Assert.assertEquals(actualTitle,expectedTitle);
        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Home page is visible");
        }else{
            System.out.println("Home page is not visible");
        }
        //4. Click on 'Signup / Login' button
        WebElement signupLoginButton2 = Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton2.click();
        BrowserUtilities.sleep(1);

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountTxt = Driver.getDriver().findElement(By.xpath("//h2[.='Login to your account']"));
        if(loginToYourAccountTxt.isDisplayed()){
            System.out.println("Login to your account is visible");
        }else {
            System.out.println("Login to your account is not visible");
        }

        //6. Enter correct email address and password

        WebElement correctEmailAddress = Driver.getDriver().findElement(By.xpath("//input[@data-qa='login-email']"));
        correctEmailAddress.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement correctPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        correctPassword.sendKeys(ConfigurationReader.getProperty("password"));

        //7. Click 'login' button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        WebElement verifyLoggedInAs = Driver.getDriver().findElement(By.tagName("b"));
        if (verifyLoggedInAs.isDisplayed()){
            System.out.println("Logged in as username is visible");
        }else {
            System.out.println("Logged in as username is not visible");
        }
/*
            //9. Click 'Delete Account' button
            WebElement deleteAccountButton = Driver.getDriver().findElement(By.xpath("//a[@href='/delete_account']"));
            deleteAccountButton.click();

            //10. Verify that 'ACCOUNT DELETED!' is visible
            WebElement isVisibleAccountDeleted = Driver.getDriver().findElement(By.xpath("//b[contains(text(),'Account Deleted!')]"));
            if (isVisibleAccountDeleted.isDisplayed()) {
                System.out.println("ACCOUNT DELETED! is visible");
            } else {
                System.out.println("ACCOUNT DELETED! is not visible");
            }

 */

    }
}