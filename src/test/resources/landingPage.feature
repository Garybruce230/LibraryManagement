@Regression @landing
Feature: Landing page Book management System



  Scenario: Validate content of landing page and move to login page
    Given I am on the landing page
    And I am validating content of the page
    When I click on Start button on landing page



  Scenario: User click on start testing button and should navigate to login page
    Given I am on the landing page
    When I click on Start button on landing page
    Then I should see Login page

