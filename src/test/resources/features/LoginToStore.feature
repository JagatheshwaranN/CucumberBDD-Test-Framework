@store
  Feature: Login to store

    @login
    Scenario Outline: Verify user login to store
      Given I'm on the Store page
      When I enter "<username>" and "<password>"
      And click on login button
      Then Account dashboard page should open
      Examples:
        | username       | password    |
        | Learn Everyday | Allowme@123 |