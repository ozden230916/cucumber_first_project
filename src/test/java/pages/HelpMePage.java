package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HelpMePage {
    public HelpMePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(tagName = "h1")
    public WebElement helpPageHeader1;

    @FindBy(xpath = "//h3")
    public WebElement helpPageHeader3;

    @FindBy(css = "a[data-qa='router-link']")
    public WebElement tryCarFinderButton;
}
