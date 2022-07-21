@parallel
Feature: OpenPageBookDepository


  Scenario: Open BookDepository page
    Given I am set the Webdriver
    When I open the "https://www.bookdepository.com/" Webpage
    Then I verify the Title, it is "Book Depository: Free delivery worldwide on over 20 million books"
    And I close the Browser
