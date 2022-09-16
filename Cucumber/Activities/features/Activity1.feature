#For activity1
  @activity1
  Feature: First Test

  @SmokeTest
  Scenario: Opening a web page using Selenium
    Given User is on Google Home page
    When User types in Cheese and hits ENTER
    Then Show How many results were shown
    And Close the Browser

