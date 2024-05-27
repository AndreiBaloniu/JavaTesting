Feature: DemoQA Scenarios

  Scenario: Click a button and verify the outcome
    Given I am on the demoqa page
    When I click on the "Click Me" button
    Then I should see the button click result

  Scenario: Select a term from a dropdown list and verify that it is selected
    Given I am on the demoqa page
    When I select "Option 1" from the dropdown
    Then "Option 1" should be selected

  Scenario: Upload a file that is saved inside the project structure
    Given I am on the demoqa page
    When I upload a file named "sample.txt"
    Then I should see the file uploaded

  Scenario: Select a new date from the date picker and check that it was selected
    Given I am on the demoqa page
    When I select a new date
    Then the new date should be displayed
