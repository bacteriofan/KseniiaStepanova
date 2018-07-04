@Regression
Feature: User Table Page Verification

  Scenario: Single scenario
    Given I am on Home Page
    And I logged in as Piter Chalovslii with login epam and password 1234
    And I open User Table through the header menu Service
    And I am on Users Table Page
    And I check Number and User columns of Users table
    Then User table contain correct values for numbers and users
    |1|Roman|
    |2|Sergey Ivan|
    |3|Vladzimir  |
    |4|Helen Bennett |
    |5|Yoshi Tannamuri|
    |6|	Giovanni Rovelli|
    When I check Description column of Users table
    Then All cells of 'Description' column contains text
    |1|Lorem ipsum|
    |2|Lorem ipsum|
    |3|Lorem ipsum|
    |4|Lorem ipsum some description|
    |5|Lorem ipsum some description|
    |6|Lorem ipsum some description|
    When I set 'vip' status to Sergey Ivan
    Then Log section shows a log row in format: Vip: condition changed to true
    When I click on dropdown in column Type for user Roman
    Then Dropdownlist contains values
    |Admin|
    |User |
    |Manager|







