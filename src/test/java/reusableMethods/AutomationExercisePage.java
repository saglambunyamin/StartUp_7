package reusableMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {

public WebDriver driver= Driver.getDriver();
    public AutomationExercisePage() {
        PageFactory.initElements(driver,this);
    }

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
    @FindBy(css = ".navbar-nav li:nth-child(5) a")
    public WebElement testCasesButton;


    //@FindBy(xpath = "//a[.=' API Testing']")
    //@FindBy(css = "li:nth-child(6) a i")
    @FindBy(css = ".navbar-nav li:nth-child(6) a")
    public WebElement apiTestingButton;


    @FindBy(css = "i.fa.fa-youtube-play")
    public WebElement videoTutorialsButton;


    @FindBy(css = "i.fa.fa-envelope")
    public WebElement contactUsButton;

}
