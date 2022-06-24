package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class OfferPage {
    public OfferPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "div[class*='hHVkqZ']")
    public WebElement offerPageText1;

    @FindBy(css = "div[class*='dJRkut']")
    public WebElement offerPageText2;

    @FindBy(css = "button[data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(css = "input[class*='jLejJf']")
    public WebElement vinInputBox;

    @FindBy(css = "span[class*='bcndwy']")
    public WebElement getMyOfferButton;

    @FindBy(css = "div[class*='kjoUgV'] ")
    public WebElement errorMessage;

}
