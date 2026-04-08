package com.yourstore.automation.questions;

import com.yourstore.automation.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IsPaymentMethodVisible implements Question<Boolean> {

    public static IsPaymentMethodVisible value() {
        return new IsPaymentMethodVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CheckoutPage.PAYMENT_METHOD_RADIO.resolveFor(actor).isVisible();
    }
}
