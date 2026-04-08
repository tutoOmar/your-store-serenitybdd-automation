package com.yourstore.automation.questions;

import com.yourstore.automation.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IsConfirmOrderVisible implements Question<Boolean> {

    public static IsConfirmOrderVisible value() {
        return new IsConfirmOrderVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.CONFIRM_ORDER_BUTTON, isVisible()).forNoMoreThan(15).seconds()
        );
        return CheckoutPage.CONFIRM_ORDER_BUTTON.resolveFor(actor).isVisible();
    }
}
