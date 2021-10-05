package steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.BlazeDemo_HomePage;
import utils.SeleniumDriver;

public class BlazeDemoSteps {

	BlazeDemo_HomePage blazeDemo = new BlazeDemo_HomePage();

	@Given("^I am on the Home Page \"([^\"]*)\" of \"([^\"]*)\" Website$")
	public void i_am_on_the_Home_Page_of_AutomationPractise_Website(String webSiteURL,String webSite) {
		SeleniumDriver.openPage(webSiteURL);

	}

	@Then("^I enter the \"([^\"]*)\" on \"([^\"]*)\"$")
	public void enterTheDetails(String details, String page, Map<String, String> map) {
		if (page.equalsIgnoreCase("BlazeDemo")) {
			blazeDemo.enterDetails(map);
		}
	}
	
	@Then("^I choose the \"([^\"]*)\" on \"([^\"]*)\"$")
	public void chooseTheFlight(String details, String page, Map<String, String> map) {
		if (page.equalsIgnoreCase("BlazeDemo")) {
			blazeDemo.enterDetails(map);
		}
	}

	@Then("^verify the \"([^\"]*)\" displayed on \"([^\"]*)\"$")
	public void validateTheDetails(String details, String page, Map<String, String> map) {

		if (page.equalsIgnoreCase("confirmationPage")) {
			blazeDemo.validateDetails(map);
		}
	}

	@And("^clicked on \"([^\"]*)\" link$")
	public void click_on_link(String link) {

		blazeDemo.clickOnElement(link);
	}

}
