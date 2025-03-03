@Regression @addbook
Feature: Add Book Library Management System

  Scenario Outline: Click on Add book button and validate page content
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



  Scenario Outline: Click on Add book details and add books and validate total number of books post adding
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<testData>" credentials
    And I am on the dashboard
    And I am validating content and Books present on catalogue should be 3
    And I click on Add Book button
    Then I navigated to Add book page and validate content
    And I added book details with "<testData>"
    And I click on Add Book button on add-book page
    And I am validating content and Books present on catalogue should be 4

    Examples:
      | testData  |
      | TestOne   |
      | TestTwo   |
      | TestThree |
      | TestFour  |


  Scenario Outline: Validation error when user click add button before filling up details.
    Given I am on the landing page
    When I click on Start button on landing page
    When I log in with credentials "<testData>" credentials
    And I am on the dashboard
    And I am validating content and Books present on catalogue should be 3
    And I click on Add Book button
    Then I navigated to Add book page and validate content
    And I click on Add Book button on add-book page
    And I will get error message on the page "<ErrorHeader>" and "<ErrorMessageOne>","<ErrorMessageTwo>","<ErrorMessageThree>","<ErrorMessageFour>","<ErrorMessageFive>" and "<ErrorMessageSix>"

    Examples:
      | testData  |ErrorHeader                         |ErrorMessageOne          |ErrorMessageTwo|ErrorMessageThree|ErrorMessageFour|ErrorMessageFive|ErrorMessageSix|
      | TestOne   |Please correct the following errors:|Title is required.|Author is required.|Genre is required.|ISBN is required.|Publication Date is required.|Price is required.|