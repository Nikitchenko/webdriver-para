@parallel
Feature: OpenPageGoogle


  Scenario: Open Google page
    Given I am set the Webdriver
    When I open the "https://www.google.com/" Webpage
    Then I verify the Title, it is "Google"
    And I close the Browser
