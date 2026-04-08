package com.yourstore.automation.questions;

import com.yourstore.automation.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GuestCheckoutFormVisible implements Question<Boolean> {

    public static GuestCheckoutFormVisible value() {
        return new GuestCheckoutFormVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CheckoutPage.FIRST_NAME_INPUT.resolveFor(actor).isVisible();
    }
}
