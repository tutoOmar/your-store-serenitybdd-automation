package com.yourstore.automation.questions;

import com.yourstore.automation.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IsPaymentMethodVisible implements Question<Boolean> {

    public static IsPaymentMethodVisible value() {
        return new IsPaymentMethodVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.PAYMENT_METHOD_RADIO, isVisible()).forNoMoreThan(15).seconds()
        );
        return CheckoutPage.PAYMENT_METHOD_RADIO.resolveFor(actor).isVisible();
    }
}
