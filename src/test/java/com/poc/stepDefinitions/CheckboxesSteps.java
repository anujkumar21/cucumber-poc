package com.poc.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.poc.pages.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckboxesSteps {
	WebDriver driver;
	PageFactory pageFactory;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pageFactory = new PageFactory(driver);

	}

	@Given("^Launch application$")
	public void launch_application() {
		driver.get("https://the-internet.herokuapp.com/");
	}

	@When("^User should be on Welcome Page$")
	public void user_should_be_on_Welcome_Page() {
		pageFactory.getWelcomePage().verifyWelcomePageTitle();
		pageFactory.getWelcomePage().verifyWelcomePageHeading();
	}

	@When("^User clicks on \"([^\"]*)\" link$")
	public void click_on_link(String lnkTxt) {
		pageFactory.getWelcomePage().clickOnLinkText(lnkTxt);
	}

	@When("^Verify Checkboxes page$")
	public void verify_checkboxes_page() {
		pageFactory.getCheckboxesPage().verifyCheckboxesPage();
	}

	@When("^Selects checkbox at index (\\d+)$")
	public void selects_checkbox_at_index(int index) throws Throwable {
		pageFactory.getCheckboxesPage().selectCheckboxes(index, true);
	}

	@Then("^Verify checkbox at index (\\d+) is selected")
	public void verify_checkbox_is_selected(int index) throws Throwable {
		pageFactory.getCheckboxesPage().verifyCheckboxStatus(index, true);
	}

	@When("^User selects all checkboxes$")
	public void user_selects_all_checkboxes() throws Throwable {
		pageFactory.getCheckboxesPage().selectAllChecboxes(true);
	}

	@Then("^Verify all checkboxes are selected$")
	public void verify_all_checkboxes_are_selected() throws Throwable {
		pageFactory.getCheckboxesPage().verifyAllCheckboxStatus(true);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
