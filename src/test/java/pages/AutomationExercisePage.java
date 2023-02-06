package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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


    // Test Case 9: Search Product
    @FindBy(css = "input#search_product")
    public WebElement searchProductBox;

    @FindBy(css = "button#submit_search")
    public WebElement searchButton;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement searchProductsHeader;

    @FindBy(css = "div.brands_products")
    public WebElement searchResult;


    // ... PAGE LOCATORS

}

