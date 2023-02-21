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

    public void closeAdPage_AfterHomePage(WebElement webElement){
        webElement.click();
        BrowserUtilities.sleep(2);
        if (Driver.getDriver().getTitle().equals("Automation Exercise")){
            Driver.getDriver().navigate().refresh();
            webElement.click();
        }
    }

    public void closeAdPage_AfterAllPage(WebElement webElement, String currentTitle){
        webElement.click();
        BrowserUtilities.sleep(2);
        if (Driver.getDriver().getTitle().equals(currentTitle)){
            Driver.getDriver().navigate().refresh();
            webElement.click();
        }
    }

    public void closeAdPage_AfterHomePage2(){
        if (Driver.getDriver().getTitle().equals("Automation Exercise")){

            Driver.getDriver().switchTo().frame("aswift_5");
            if (Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).isDisplayed()){
                Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).click();
            }else {
                Driver.getDriver().switchTo().frame("ad_iframe");
                Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).click();
            }

            Driver.getDriver().switchTo().parentFrame();
        }
    }







}



