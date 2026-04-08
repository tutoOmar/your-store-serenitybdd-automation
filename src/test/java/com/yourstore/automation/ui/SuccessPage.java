package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SuccessPage {

    public static final Target ORDER_PLACED_HEADING = Target.the("order placed heading")
            .locatedBy("css:#content h1");

    private SuccessPage() {
    }
}
