package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.Driver;
import utils.Waiter;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    HelpMePage helpMePage;
    CarFinderPage carFinderPage;
    OfferPage offerPage;
    FinancingPage financingPage;



    @Before
    public void setUp(){
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        helpMePage = new HelpMePage();
        carFinderPage = new CarFinderPage();
        offerPage = new OfferPage();
        financingPage = new FinancingPage();

    }


    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text){
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(helpMePage.helpPageHeader1.isDisplayed());
                Assert.assertEquals(text, helpMePage.helpPageHeader1.getText());
                break;

            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(helpMePage.helpPageHeader3.isDisplayed());
                Assert.assertEquals(text, helpMePage.helpPageHeader3.getText());
                break;

            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(carFinderPage.carFinderMainHeading.isDisplayed());
                Assert.assertEquals(text, carFinderPage.carFinderMainHeading.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(carFinderPage.carFinderSubHeader.isDisplayed());
                Assert.assertEquals(text, carFinderPage.carFinderSubHeader.getText());
                break;

            case "GET A REAL OFFER IN 2 MINUTES" :
                Assert.assertTrue(offerPage.offerPageText1.isDisplayed());
                Assert.assertEquals(text, offerPage.offerPageText1.getText());
                break;
            case "We pick up your car. You get paid on the spot." :
                Assert.assertTrue(offerPage.offerPageText2.isDisplayed());
                Assert.assertEquals(text, offerPage.offerPageText2.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again." :
                Waiter.waitUntilTextToBePresentInElement(driver, 5, offerPage.errorMessage,text);
                Assert.assertTrue(offerPage.errorMessage.isDisplayed());
                Assert.assertEquals(text, offerPage.errorMessage.getText());

                break;

        }

    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String link) {
        Assert.assertTrue(helpMePage.tryCarFinderButton.isDisplayed());
        Assert.assertEquals(link, helpMePage.tryCarFinderButton.getText());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String linkText) {
                helpMePage.tryCarFinderButton.click();

    }


    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonText) {
        Waiter.pause(30);
        switch (buttonText){
            case "VIN" :
                offerPage.vinButton.click();
                break;
            case "GET MY OFFER":
                offerPage.getMyOfferButton.click();
                break;
        }
    }


    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String vinNumber) {
        offerPage.vinInputBox.click();
        Waiter.pause(3);
        offerPage.vinInputBox.sendKeys(vinNumber);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String linkText) {
        Actions actions = new Actions(driver);
        actions.moveToElement(carvanaHomePage.financingLink).perform();

    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String text, String cost) {
        switch (text){
            case "Cost of Car I want" :
                Assert.assertTrue(financingPage.costOfCarInputBox.isDisplayed());
                financingPage.costOfCarInputBox.sendKeys(cost);
                break;
            case "What is Your Down Payment?" :
                Assert.assertTrue(financingPage.downPaymentInputBox.isDisplayed());
                financingPage.downPaymentInputBox.sendKeys(cost);
                break;
        }

    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String text, String selection) {
        Select select;
        switch (text){
            case "What’s Your credit Score?" :
                select = new Select(financingPage.creditScoreDropdown);
                select.selectByIndex(0);
                break;
            case "Choose Your Loan Terms":
                select = new Select(financingPage.loanTermDropdown);
                select.selectByIndex(1);
                break;
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String monthlyPayment) {
        Assert.assertTrue(financingPage.loanCalculator.isDisplayed());
        Assert.assertEquals(monthlyPayment, financingPage.loanCalculator.getText());
    }
}
