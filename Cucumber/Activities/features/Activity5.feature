#For activity5
@activity5
Feature: Login Test Activity5

  @regression
  Scenario: Testing Login with Examples
    Given User is on Testing Login page
    When User enters "<usernames>" and "<passwords>"
    Then Read the page title and show the confirmation message
    And Close the browser

    Examples:
      | usernames | passwords |
      | admin    | password |
      | admin1    | password1 |

