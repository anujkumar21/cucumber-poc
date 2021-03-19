package com.poc.stepDefinitions;

import com.poc.pages.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DropdownSteps {

    PageFactory pageFactory = PageFactory.getInstance();

    @Then("Verify Dropdown page")
    public void verify_Dropdown_page() {
        pageFactory.getDropdownPage().verifyDropDownPage();
    }

    @When("User selects option {string} from dropdown")
    public void user_selects_option_from_dropdown(String visibleTxt) {
        pageFactory.getDropdownPage().selectDropdown(visibleTxt);
    }

    @Then("Option {string} is selected")
    public void option_is_selected(String opt) {
        pageFactory.getDropdownPage().verifySelectOptioInDropDown(opt);
    }

}
