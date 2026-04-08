package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static final Target GUEST_CHECKOUT_RADIO = Target.the("guest checkout radio button")
            .locatedBy("css:input[name='account'][value='guest']");

    public static final Target CONTINUE_BUTTON = Target.the("continue button on checkout options")
            .locatedBy("css:#button-account");

    public static final Target BILLING_DETAILS_FORM = Target.the("billing details form")
            .locatedBy("css:#checkout-payment-address");

    public static final Target FIRST_NAME_INPUT = Target.the("first name input in billing form")
            .locatedBy("css:#input-payment-firstname");

    private CheckoutPage() {
    }
}
