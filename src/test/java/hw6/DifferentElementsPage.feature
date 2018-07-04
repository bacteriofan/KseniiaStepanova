@Regression
Feature: Different Elements Page Verification

  Scenario: Single scenarioh
    Given I am on Main Page
    When I login as user epam with password 1234
    Then User name is PITER CHAILOVSKII
    Then 4 pictures are displayed
    Then Texts under images are correct
    Then Main headers texts are correct
    When I open Service dropdown list
    Then Service dropdown list is correct
    Then Service left panel list is correct
    When I open Different elements page through Service dropdown list
    Then 4 checkboxes are displayed
    Then 4 radio buttons are displayed
    Then Dropdown is displayed
    Then Right section is displayed
    Then Left section is displayed
    When I click Water checkbox
    Then I check log: Water checkbox is true
    When I click Wind checkbox
    Then I check log: Wind checkbox is true
    When I select Selen radio button
    Then I check log: Selen value is changed
    When I select color Yellow from dropdown
    Then I check log: Yellow value is changed
    When I click Water checkbox
    Then I check log: Water checkbox is false
    When I click Wind checkbox
    Then I check log: Wind checkbox is false