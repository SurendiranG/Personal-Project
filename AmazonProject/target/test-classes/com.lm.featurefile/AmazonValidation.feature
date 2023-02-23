Feature: To validate the Amazon Application
  Scenario: To validate the Login page of the Amazon Application
    Given User navigates to the given Amazon login page
    When User enters the valid credentials and navigate to Homepage
    And User clicks the signout button
    Then User should verify that signout successfully

   @TestID2
  Scenario: To validate the cart functionality
    Given User navigates to the Homepage
    When User select the item and add to the cart
    And User verify the item added successfully
    When User removes the item added on the cart
    Then User should verify that the item is removed successfully