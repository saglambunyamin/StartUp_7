package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutomationExercisePage {

    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // MAIN PAGE LOCATORS
    @FindBy(css = "i.fa.fa-lock")//FindBy is an annotation. It is a shortcut for FindElement (By.)
    public WebElement signupLoginButton;//Bu ikili yapı standarttır. İstediğimiz kadar oluşturabiliriz. Farklı farklı locator da kullanabiliriz.


    @FindBy(css = "i.fa.fa-home")
    public WebElement homeButton;


    @FindBy(css = "i.fa.fa-shopping-cart")
    public WebElement chartButton;


    @FindBy(css = "i.material-icons.card_travel")
    public WebElement productButton;


    //@FindBy(xpath = "(//a[@href=\"/test_cases\"])[1]")
    //@FindBy(css = "li:nth-child(5) a i")
    //@FindBy(css = ".navbar-nav li:nth-child(5) a")
    @FindBy(css = "div.item.active div.col-sm-6 a.test_cases_list")
    public WebElement testCasesButton;


    //@FindBy(xpath = "//a[.=' API Testing']")
    //@FindBy(css = "li:nth-child(6) a i")
    //@FindBy(css = ".navbar-nav li:nth-child(6) a")
    @FindBy(css = "div.item.active div.col-sm-6 a.apis_list")
    public WebElement apiTestingButton;


    @FindBy(css = "i.fa.fa-youtube-play")
    public WebElement videoTutorialsButton;


    @FindBy(css = "i.fa.fa-envelope")
    public WebElement contactUsButton;


    // Test Case 8: Product Details
    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    public WebElement viewProductBlueTop;

    @FindBy(xpath = "//h2[.='Blue Top']")
    public WebElement productNameBlueTop ;

    @FindBy(xpath = "//p[.='Category: Women > Tops']")
    public WebElement categoryBlueTop ;

    @FindBy(xpath = "//span[.='Rs. 500']")
    public WebElement priceBlueTop ;

    @FindBy(xpath = "//b[.='Availability:']")
    public WebElement availabilityBlueTop ;

    @FindBy(xpath = "//b[.='Condition:']")
    public WebElement conditionBlueTop ;

    @FindBy(xpath = "//b[.='Brand:']")
    public WebElement brandBlueTop;

    public void verifySelectedProductDetailsVisibility() {
        List<WebElement> allDetails=new ArrayList<>();
        allDetails.addAll(Arrays.asList(brandBlueTop,conditionBlueTop,availabilityBlueTop,priceBlueTop,productNameBlueTop,categoryBlueTop));

        for (WebElement eachDetail : allDetails) {
            Assert.assertTrue(eachDetail.isDisplayed(),eachDetail.getText()+" is not visible");
            System.out.println(eachDetail.getText()+" is displayed");
        }


    }

    public void closeAdWindow(){
        Driver.getDriver().switchTo().frame("aswift_5");
        Driver.getDriver().switchTo().frame("ad_iframe");
        Driver.getDriver().findElement(By.cssSelector("div#dismiss-button")).click();
        Driver.getDriver().switchTo().parentFrame();
    }


    // Test Case 9: Search Product
    @FindBy(css = "input#search_product")
    public WebElement searchProductBox;

    @FindBy(css = "div.productinfo.text-center p")
    public List<WebElement> allProducts;

    public void selectRandomItemFromAllProductsAndSearchForIt(){
        int randomItemIndexFromAllProductsList=BrowserUtilities.random().nextInt(allProducts.size());
        searchProductBox.sendKeys(allProducts.get(randomItemIndexFromAllProductsList).getText());
        searchButton.click();
    }
    @FindBy(css = "button#submit_search")
    public WebElement searchButton;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement searchProductsHeader;

    @FindBy(css = "div.brands_products")
    public WebElement brandsInfoColumn;

    @FindAll(@FindBy(css = "div.productinfo.text-center"))
    public List<WebElement> allSearchResults;

    // ... PAGE LOCATORS

}

