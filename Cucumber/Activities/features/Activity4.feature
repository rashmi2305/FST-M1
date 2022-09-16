#For activity4
@activity4
Feature: Login Test Activity4

  @SmokeTest
  Scenario: Testing Login without Examples
    Given User is on Testing Login page
    When User enters "admin" and "password"
    Then Read the page title and show the confirmation message
    And Close the browser

