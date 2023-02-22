package pages.DarknessPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VerifySubscriptionInCartPage {
    public VerifySubscriptionInCartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()=' Cart']")
    public WebElement cartButton;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement subscriptionText;

    @FindBy(css = "input#susbscribe_email")
    public WebElement subscribeEmailBox;

    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    public WebElement arrowButton;

    @FindBy(xpath = "//div[@id='success-subscribe']")
    public  WebElement successMessage;

}
