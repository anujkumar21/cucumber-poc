Feature: Dropdown Page 

Background: 
	Given   Launch application 
	When   User should be on Welcome Page 
	And User clicks on "Dropdown" link 
	Then Verify Dropdown page 
	
Scenario: Select option in dropdown by visible text 
	When User selects option "Option 2" from dropdown 
	Then Option "Option 2" is selected
