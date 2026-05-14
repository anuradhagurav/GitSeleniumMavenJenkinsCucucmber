package StepDefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import browser_set_up.BrowserSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleSearch;
import utils.ReadExcel;
import utils.ReadProperties;

public class GoogleSearchSteps {

	WebDriver driver;
	
	ReadProperties rp = new ReadProperties();
	
	@Given("I am on the search page")
	public void i_am_on_the_search_page() throws IOException {
		
		BrowserSetup bs = new BrowserSetup();
		driver = bs.setupBrowser("Chrome");
		driver.get(rp.ReadProperty("./src/main/resources/config.properties", "url"));
	}

	@When("I search for a keyword")
	public void i_search_for_a_keyword() {
//GoogleSearch searchPage = new GoogleSearch(driver);
		
//		ReadExcel re = new ReadExcel();
		GoogleSearch searchPage = new GoogleSearch(driver);
	
		searchPage.enterKeyword("Testing");
	}

	@Then("I should see search results for keyword")
	public void i_should_see_search_results_for_keyword() {
//		Assert.assertEquals(driver.getTitle(), "Practice Page");
		System.out.println("Step Completed");
		
		driver.quit();
	}


}
