package pages.MyPages_Bilal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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


    //----------------------------------------------------------------------//
                //=======Methods about HomePage=======//

    public void assertWebTableElements(int trFirstIndex, int trLastIndex, int tdFirstIndex, int tdLastIndex){

        for (int i = trFirstIndex; i <= trLastIndex; i++) {
            for (int j = tdFirstIndex; j <= tdLastIndex; j++) {
                Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")).isDisplayed());

            }
        }

    }



}
