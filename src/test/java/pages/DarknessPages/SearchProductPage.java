package pages.DarknessPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

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

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    public List<WebElement> allSearchProducts;

    public void verifyAllTheProductsRelatedToSearch(){
        int i=1;
        for (WebElement eachProduct : allSearchProducts) {
            System.out.println(i+". product information is below");
            Assert.assertTrue(eachProduct.isDisplayed(), eachProduct.getText() + " is not visible");
            System.out.println(eachProduct.getText() + " is visible");
            System.out.println("-------------");
            i++;
        }

    }
}
