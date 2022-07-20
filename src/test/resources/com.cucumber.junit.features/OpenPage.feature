@parallel
Feature: OpenPage


  Scenario: Open Google page
    Given I am set the Webdriver
    When I open the 'Google' Webpage
    Then I verify the Title, it is "Google"
    And I close the Browser


  Scenario: Open EPAM page
    Given I am set the Webdriver
    When I open the 'EPAM' Webpage
    Then I verify the Title, it is "EPAM | Enterprise Software Development, Design & Consulting"
    And I close the Browser


  Scenario: Open BookDepository page
    Given I am set the Webdriver
    When I open the 'BookDepository' Webpage
    Then I verify the Title, it is "Book Depository: Free delivery worldwide on over 20 million books"
    And I close the Browser



