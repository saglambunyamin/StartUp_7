package pages.MyPages_Bilal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = " //a[.='View Product']")
    public List<WebElement> viewProductButtons;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingButton;



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


    public void addProductsRandomly(int numberOfAddedProducts){

        Random random= new Random();
        Actions actions=new Actions(Driver.getDriver());
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

        for (int i=0;i<numberOfAddedProducts;i++){
            int randomNumber=  random.nextInt(viewProductButtons.size());
            System.out.println(randomNumber);
            WebElement randomAddtoCart=Driver.getDriver().findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])["+
                    randomNumber +"]"));
            System.out.println(randomAddtoCart.getText());
            js.executeScript("arguments[0].scrollIntoView(true);", randomAddtoCart);
            BrowserUtilities.sleep(2);
            actions.moveToElement(randomAddtoCart).pause(2000).perform();
            randomAddtoCart.click();
            BrowserUtilities.sleep(2);
            continueShoppingButton.click();
            BrowserUtilities.sleep(2);


        }


    }

//(//a[@class='btn btn-default add-to-cart'])[10]





}



