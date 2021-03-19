Feature: Checkboxes Page

  Background:
    Given   Launch application
    When   User should be on Welcome Page
    And User clicks on "Checkboxes" link
    Then Verify Checkboxes page

  Scenario: Select Desired Checkbox
    When Selects checkbox at index 2
    Then Verify checkbox at index 2 is selected

  Scenario: Select All Checkbox
    When User selects all checkboxes
    Then Verify all checkboxes are selected
