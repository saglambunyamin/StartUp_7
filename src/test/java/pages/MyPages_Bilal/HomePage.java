package pages.MyPages_Bilal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    public void closeAdPage_AfterHomePage(){
        if (Driver.getDriver().getTitle().equals("Automation Exercise")){

            Driver.getDriver().switchTo().frame("aswift_4");
            Driver.getDriver().switchTo().frame("ad_iframe");

            if (Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).isDisplayed()){
                Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).click();
            }else {
                Driver.getDriver().findElement(By.xpath("//div[@id='ad_position_box div#dismiss-button path']")).click();
            }

            Driver.getDriver().switchTo().parentFrame();
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



