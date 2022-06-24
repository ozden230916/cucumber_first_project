package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class FinancingPage {
    public FinancingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement costOfCarInputBox;
    @FindBy(id = "creditBlock")
    public WebElement creditScoreDropdown;
    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTermDropdown;
    @FindBy(css = "input[name='downPayment']")
    public WebElement downPaymentInputBox;
    @FindBy(css = ".loan-calculator-display-value")
    public WebElement loanCalculator;


}
