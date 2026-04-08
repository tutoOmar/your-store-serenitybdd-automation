Feature: Add products to cart and complete guest checkout

  Scenario Outline: Add two products and complete guest checkout with billing form
    Given the user is on the home page
    When he adds products to the cart
    And he opens the cart dropdown
    Then the cart should contain 2 products
    And the cart dropdown should be visible
    When he clicks on view cart
    Then he should be on the cart page
    When he proceeds as guest checkout
    Then the guest checkout form should be visible
    When he fills the form with "<firstName>", "<lastName>", "<email>", "<telephone>", "<address>", "<city>", "<postcode>", "<country>", "<zone>"
    Then the guest checkout form should not be visible
    When he continues with the delivery method
    Then the payment method section should be visible
    When he accepts the payment method

    Examples:
      | firstName | lastName | email                   | telephone  | address    | city     | postcode | country  | zone            |
      | Juan      | Perez    | juan.perez@test.com     | 3001234567 | Calle 123  | Bogota   | 110111   | Colombia | Bogota D.C.     |
      | Maria     | Lopez    | maria.lopez@test.com    | 3109876543 | Carrera 45 | Medellin | 050021   | Colombia | Antioquia       |
      | Carlos    | Ramirez  | carlos.ramirez@test.com | 3205551234 | Avenida 80 | Guayaquil| 090150   | Ecuador  | Bolivar         |
