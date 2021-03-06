package com.poc.stepDefinitions;

import com.poc.pages.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckboxesSteps {

    PageFactory pageFactory = PageFactory.getInstance();

    @When("User should be on Welcome Page")
    public void user_should_be_on_Welcome_Page() {
        pageFactory.getWelcomePage().verifyWelcomePageTitle();
        pageFactory.getWelcomePage().verifyWelcomePageHeading();
    }

    @When("User clicks on {string} link")
    public void click_on_link(String lnkTxt) {
        pageFactory.getWelcomePage().clickOnLinkText(lnkTxt);
    }

    @When("Verify Checkboxes page")
    public void verify_checkboxes_page() {
        pageFactory.getCheckboxesPage().verifyCheckboxesPage();
    }

    @When("Selects checkbox at index {int}")
    public void selects_checkbox_at_index(int index) {
        pageFactory.getCheckboxesPage().selectCheckboxes(index, true);
    }

    @Then("Verify checkbox at index {int} is selected")
    public void verify_checkbox_is_selected(int index) {
        pageFactory.getCheckboxesPage().verifyCheckboxStatus(index, true);
    }

    @When("User selects all checkboxes")
    public void user_selects_all_checkboxes() {
        pageFactory.getCheckboxesPage().selectAllChecboxes(true);
    }

    @Then("Verify all checkboxes are selected")
    public void verify_all_checkboxes_are_selected() {
        pageFactory.getCheckboxesPage().verifyAllCheckboxStatus(true);
    }

}
