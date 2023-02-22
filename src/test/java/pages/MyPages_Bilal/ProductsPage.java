package pages.MyPages_Bilal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement searchPruduct;

    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement searchButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement searchedProductsText;

    @FindBy(xpath = "//p[contains(.,'Top')]")
    public static List<WebElement> topList;

    @FindBy(xpath = "//a[@data-product-id='1']")
    public WebElement firstProduct;

    @FindBy(xpath = "//a[@data-product-id='2']")
    public WebElement secondProduct;

    @FindBy(xpath = "//u[.='View Cart']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingButton;





}
