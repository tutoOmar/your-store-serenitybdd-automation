package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target ADD_TO_CART_FIRST_PRODUCT = Target.the("Add to cart button of first product")
        .locatedBy("(//button[contains(@onclick,'cart.add')])[1]");
    
    private HomePage() {
    }
}