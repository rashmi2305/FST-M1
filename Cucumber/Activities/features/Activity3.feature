#For Activity3
@activity3
Feature: Alerts_Activity3

  @SimpleAlert @SmokeTest
  Scenario: Testing Simple Alert
    Given User is on the page
    When User clicks on Simple Alert
    Then Read Alert Text
    And Accept Alert
    And Close browser

  @ConfirmAlert
  Scenario: Testing Confirm Alert
    Given User is on the page
    When User clicks on Confirm Alert
    Then Read Alert Text
    And Accept Alert
    And Close browser

  @PromptAlert
  Scenario: Testing Prompt Alert
    Given User is on the page
    When User clicks on Prompt Alert
    Then Enter Value in prompt popup
    And Accept Alert
    And Close browser