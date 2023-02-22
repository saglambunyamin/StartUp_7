package pages.MyPages_Bilal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = " //a[@href='/products']")
    public WebElement productsButton;

    @FindBy(xpath = "//h2[.='Subscription']")
    public WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    public WebElement subscribeEmail;

    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    public WebElement arrowCircle;


    @FindBy(id = "success-subscribe")
    public  WebElement successMessage;

    @FindBy(xpath = " //a[@href='/view_cart']")
    public WebElement cartButton;




    //----------------------------------------------------------------------//
                    //Methods about HomePage//

    public static void closeAdPage_AfterHomePage(WebElement webElement){
        webElement.click();
        BrowserUtilities.sleep(2);
        if (Driver.getDriver().getTitle().equals("Automation Exercise")){
            Driver.getDriver().navigate().refresh();
            webElement.click();
        }
    }

    public void click_and_closeAdPage_AfterHomePage(WebElement webElement){
        webElement.click();
        BrowserUtilities.sleep(2);
        if (Driver.getDriver().getTitle().equals("Automation Exercise")){
            Driver.getDriver().navigate().refresh();
            webElement.click();
        }
    }

    public void click_and_closeAdPage_AfterAllPages(WebElement webElement, String currentTitle){
        webElement.click();
        BrowserUtilities.sleep(2);
        if (Driver.getDriver().getTitle().equals(currentTitle)){
            Driver.getDriver().navigate().refresh();
            webElement.click();
        }
    }









}



