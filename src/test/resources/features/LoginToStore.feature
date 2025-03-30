@store
  Feature: Login to store

    @login @positive
    Scenario Outline: Verify user login to store - positive scenario
      Given I'm on the Store page
      When I enter login details from given sheet "<sheetName>" and row <rowNumber>
      And click on login button
      Then Account dashboard page should open
      Examples:
        | sheetName | rowNumber |
        | LoginPage | 0         |

    @login @negative
    Scenario Outline: Verify user login to store - negative scenario
      Given I'm on the Store page
      When I enter login details from given sheet "<sheetName>" and row <rowNumber>
      And click on login button
      Then Login "<error_type>" error message should display
      Examples:
        | sheetName | rowNumber | error_type |
        | LoginPage | 1         | username   |
        | LoginPage | 2         | password   |