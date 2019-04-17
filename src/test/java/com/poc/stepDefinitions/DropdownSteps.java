package com.poc.stepDefinitions;

import com.poc.pages.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DropdownSteps {

	PageFactory pageFactory = PageFactory.getInstance();

	@Then("^Verify Dropdown page$")
	public void verify_Dropdown_page() throws Throwable {
		pageFactory.getDropdownPage().verifyDropDownPage();
	}

	@When("^User selects option \"([^\"]*)\" from dropdown$")
	public void user_selects_option_from_dropdown(String visibleTxt) throws Throwable {
		pageFactory.getDropdownPage().selectDropdown(visibleTxt);
	}

	@Then("^Option \"([^\"]*)\" is selected$")
	public void option_is_selected(String opt) throws Throwable {
		pageFactory.getDropdownPage().verifySelectOptioInDropDown(opt);
	}

}
