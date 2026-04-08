package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target SUCCESS_NOTIFICATION = Target.the("success notification")
            .locatedBy(".alert-success");

    public static Target addToCartButton(int index) {
        return Target.the("Add to cart button #" + index)
                .locatedBy("(//button[contains(@onclick,'cart.add')])[" + index + "]");
    }

    private HomePage() {
    }
}