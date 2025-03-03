@Regression @catalogue
Feature: Dashboard Book Management System

  Scenario Outline: User navigating to book catalogue page
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<testData>" credentials
    And I am on the dashboard
    Examples:
      | testData |
      |  TestOne |




  Scenario Outline: Validate content of catalogue page
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<testData>" credentials
    And I am on the dashboard
    And I am validating content and Books present on catalogue should be 3
    Examples:
      | testData  |
      | TestOne   |


  Scenario Outline: Delete book functionality
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<testData>" credentials
    And I am on the dashboard
    And I am validating content and Books present on catalogue should be 3
    Then I delete first book
    And I am validating content and Books present on catalogue should be 2
    Examples:
      | testData  |
      | TestOne   |


  Scenario Outline: Click on Add book button
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<testData>" credentials
    And I am on the dashboard
    And I am validating content and Books present on catalogue should be 3
    And I click on Add Book button
    Then I navigated to Add book page and validate content
    Examples:
      | testData  |
      | TestOne   |



  Scenario Outline: Test Logout feature
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<testData>" credentials
    And I am on the dashboard
    Then I click on logout button
  #  And I should see Login page   (DEFECT)

    Examples:
      | testData  |
      | TestOne   |

