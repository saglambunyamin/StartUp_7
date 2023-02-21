package pages.MyPages_Bilal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class View_cartPage {

    public View_cartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[.='Subscription']")
    public WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    public WebElement subscribeEmail;

    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    public WebElement arrowCircle;


    @FindBy(id = "success-subscribe")
    public  WebElement successMessage;



}
