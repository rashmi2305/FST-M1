#For Activity2
@activity2
Feature: LoginTest_Activity2

  @Login
  Scenario: Testing Login
    Given User is on Testing Login page
    When User enters username and password
    Then Read the page title and show the confirmation message
    And Close the browser