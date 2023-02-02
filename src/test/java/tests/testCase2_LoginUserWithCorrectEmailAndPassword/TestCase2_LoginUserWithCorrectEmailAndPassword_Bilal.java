package tests.testCase2_LoginUserWithCorrectEmailAndPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import reusableMethods.BrowserUtilities;
import testBase.TestBaseBeforeClassAfterClass;


public class TestCase2_LoginUserWithCorrectEmailAndPassword_Bilal extends TestBaseBeforeClassAfterClass {


    @Test
    public void correctUserTest(){

    //1. Create an account and logout
        driver.get("https://automationexercise.com/");

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        BrowserUtilities.sleep(2);

        String userName= faker.name().username();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
        String email= faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        BrowserUtilities.sleep(2);


        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("123456789");

        Select selectDay= new Select(driver.findElement(By.xpath("//select[@data-qa='days']")));
        Select selectMonth= new Select(driver.findElement(By.xpath("//select[@data-qa='months']")));
        Select selectYear= new Select(driver.findElement(By.xpath("//select[@data-qa='years']")));

        selectDay.selectByIndex(faker.number().numberBetween(1,31));
        selectMonth.selectByIndex(faker.number().numberBetween(1,12));
        selectYear.selectByIndex(faker.number().numberBetween(1,100));

        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().fullAddress());
        Select selectCountry= new Select(driver.findElement(By.xpath("//select[@data-qa='country']")));
        selectCountry.selectByIndex(faker.number().numberBetween(0,6));
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.numerify("###-###-####"));
        BrowserUtilities.sleep(2);
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        BrowserUtilities.sleep(2);

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        BrowserUtilities.sleep(2);
        driver.switchTo().frame("aswift_2");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ad_iframe']")));
        driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        driver.switchTo().parentFrame();

        BrowserUtilities.sleep(2);
        driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]")).click();


    //2. Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");

    //3. Verify that home page is visible successfully
    String expectedTitle = "Automation Exercise";
    if (driver.getTitle().equals(expectedTitle)){
        System.out.println("Page Verification PASSED");
    }else {
        System.out.println("Page Verification FAİLED");
    }

    //4. Click on 'Signup / Login' button
    driver.findElement(By.xpath("//a[@href='/login']")).click();
    BrowserUtilities.sleep(2);

    //5. Verify 'Login to your account' is visible
    String loginAccount=driver.findElement(By.xpath("//h2[.='Login to your account']")).getText();

    if (loginAccount.equals("Login to your account")){
        System.out.println("'Login to your account' is VISIBLE");
    }else {
        System.out.println("'Login to your account' is NOT VISIBLE");
    }

    //6. Enter correct email address and password
    driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(email);
    driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456789");

    //7. Click 'login' button
    driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

    //8. Verify that 'Logged in as username' is visible
    String loggedInVerify= driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[10]/a")).getText();
    System.out.println(loggedInVerify);
    if (loggedInVerify.equals("Logged in as " + userName)){
        System.out.println("'Logged in as username' is VISIBLE");
    }else {
        System.out.println("'Logged in as username' is NOT VISIBLE");
    }
    //9. Click 'Delete Account' button
    BrowserUtilities.sleep(2);
    driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]")).click();

    //10. Verify that 'ACCOUNT DELETED!' is visible
    String deletedVerify= driver.findElement(By.xpath("//b[.='Account Deleted!']")).getText();
    if (deletedVerify.equals("ACCOUNT DELETED!")){
        System.out.println("'ACCOUNT DELETED!' is VISIBLE");
    }else {
        System.out.println("'ACCOUNT DELETED!' is NOT VISIBLE");
    }


    }

}
