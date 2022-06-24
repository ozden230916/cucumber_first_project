package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarFinderPage {
    public CarFinderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "div[data-qa='headline']")
    public WebElement carFinderMainHeading;

    @FindBy(css = "div[data-qa='sub-heading']")
    public WebElement carFinderSubHeader;


}
