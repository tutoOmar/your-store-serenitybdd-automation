Feature: Add products to cart

  Scenario: Add two products and verify cart dropdown
    Given the user is on the home page
    When he adds products to the cart
    And he opens the cart dropdown
    Then the cart should contain 2 products
    And the cart dropdown should be visible
    When he clicks on view cart
    Then he should be on the cart page
