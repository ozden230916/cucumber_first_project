package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CarvanaHomePage;
import utils.Driver;
import utils.Waiter;

public class BaseSteps {
    WebDriver driver;
    WebDriverWait explicitWait;
    CarvanaHomePage carvanaHomePage;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 15);
        carvanaHomePage = new CarvanaHomePage();
    }
    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String link) {
        Waiter.pause(15);
        switch (link){
            case "CAR FINDER":
                carvanaHomePage.carFinderLink.click();
                break;
            case "SELL/TRADE":
                carvanaHomePage.sellTradeLink.click();
                break;
            case "AUTO LOAN CALCULATOR":
                carvanaHomePage.autoLoanCalculatorLink.click();

        }

    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());

    }
}
