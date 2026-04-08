Feature: Add products to cart

  Scenario: Add two products to cart
    Given the user is on the home page
    When he adds products to the cart
    Then the cart should contain 2 products
