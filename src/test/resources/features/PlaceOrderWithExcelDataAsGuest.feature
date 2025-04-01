@store
Feature: Place Order

  @placeOrder @excel
  Scenario: Verify user able to place order as guest user by fetching data from excel.
    Given I'm a guest user
    And my billing details are taken from excel sheet "Billing Info"
    And I have a "Blue Shoes" in the cart
    And I'm on the checkout page
    When I provide the billing details
    And I place an order
    Then the order should be placed successfully