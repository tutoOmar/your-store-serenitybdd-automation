package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target SUCCESS_NOTIFICATION = Target.the("success notification")
            .locatedBy(".alert-success");

    public static final Target CART_TOTAL = Target.the("cart total in header")
            .locatedBy("#cart-total");

    public static final Target CART_DROPDOWN_BUTTON = Target.the("cart dropdown button in header")
            .locatedBy("#cart > button");

    public static final Target CART_DROPDOWN_MENU = Target.the("cart dropdown menu")
            .locatedBy("#cart ul.dropdown-menu");

    public static final Target VIEW_CART_BUTTON = Target.the("view cart button in dropdown")
            .locatedBy("#cart ul.dropdown-menu a[href*='checkout/checkout']");

    public static Target addToCartButton(int index) {
        return Target.the("Add to cart button #" + index)
                .locatedBy("(//button[contains(@onclick,'cart.add')])[" + index + "]");
    }

    private HomePage() {
    }
}