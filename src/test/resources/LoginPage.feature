@Regression @login
Feature: book Management System

  Scenario: User landing on start page
    Given I am on the landing page



  Scenario Outline: Validate content of landing page and move to login page
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<loginId>" and "<Password>"
    And I am on the dashboard
    Examples:
      | loginId  | Password     |
      |admin1    |securePassword|


  Scenario Outline: Validate content of landing page and move to login page using example table
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<testData>" credentials
    And I am on the dashboard

    Examples:
      | testData  |
      | TestOne   |



  Scenario Outline: User Enter invalid credentials
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<testData>" credentials
    Then I should see error message "<ErrorTitle>" and "<ErrorMessage>" and "<ErrorMessageTwo>" on Login page


    Examples:
      | testData                 | ErrorTitle                             |ErrorMessage                                   | ErrorMessageTwo         |
      | TestInvalidUser              |There is a problem with your submission |Invalid username or password. Please try again.| NA                      |
      | TestInvalidPassword          |There is a problem with your submission |Invalid username or password. Please try again.| NA                      |
      | TestInavlidUserPassword      |There is a problem with your submission |Invalid username or password. Please try again.| NA                      |
      | TestMissingUserId            |There is a problem with your submission |Please enter your username                     | NA                       |
      | TestMissingPassword          |There is a problem with your submission |Please enter your password                     | NA                       |
      | TestMissingUserPassword      |There is a problem with your submission |Please enter your username                     |Please enter your password|
