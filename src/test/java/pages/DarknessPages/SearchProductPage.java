package pages.DarknessPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchProductPage {
    public SearchProductPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsButton;

    @FindBy(xpath = "//h2[text()='All Products']")
    public WebElement allProducts;

    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement searchProductBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement searchButton;

    @FindBy(xpath = "//h2[.='Searched Products']")
    public WebElement searchedProducts;
}
