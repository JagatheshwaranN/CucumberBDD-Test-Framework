@store
  Feature: Login to store

    @login
    Scenario Outline: Verify user login to store
      Given I'm on the Store page
      When I enter login details from given sheet "<sheetName>" and row <rowNumber>
      And click on login button
      Then Account dashboard page should open
      Examples:
        | sheetName | rowNumber |
        | LoginPage | 0         |