package com.yourstore.automation.questions;

import com.yourstore.automation.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IsConfirmOrderVisible implements Question<Boolean> {

    public static IsConfirmOrderVisible value() {
        return new IsConfirmOrderVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CheckoutPage.CONFIRM_ORDER_BUTTON.resolveFor(actor).isVisible();
    }
}
