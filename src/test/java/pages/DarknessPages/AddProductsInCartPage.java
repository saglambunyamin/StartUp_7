package pages.DarknessPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

public class AddProductsInCartPage {
    public AddProductsInCartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsButton;

    @FindBy(xpath = "//img[@src='/get_product_picture/1']")
    public WebElement firstProduct;

    @FindBy(xpath = "//img[@src='/get_product_picture/2']")
    public WebElement secondProduct;

    @FindBy(css = "div[class='overlay-content']>a[data-product-id='1']")
    public WebElement firstProductAddToCart;

    @FindBy(css = "div[class='overlay-content']>a[data-product-id='2']")
    public WebElement secondProductAddToCart;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    public WebElement viewCartButton;

    @FindBy(xpath = "//tr[@id='product-1']")
    public WebElement firstAddedProduct;

    @FindBy(xpath = "//tr[@id='product-2']")
    public WebElement secondAddedProduct;


    public void verifyFirstAndSecondProductInformation(){
        for (int i = 1; i <= 6; i++) {
            WebElement firstProductInformation=Driver.getDriver().findElement(By.xpath("//tr[@id='product-1']/td["+i+"]"));
            Assert.assertTrue(firstProductInformation.isDisplayed());

            WebElement secondProductInformation=Driver.getDriver().findElement(By.xpath("//tr[@id='product-2']/td["+i+"]"));
            Assert.assertTrue(secondProductInformation.isDisplayed());
        }
    }

}
