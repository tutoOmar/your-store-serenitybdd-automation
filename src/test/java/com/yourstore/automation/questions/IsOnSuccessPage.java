package com.yourstore.automation.questions;

import com.yourstore.automation.ui.SuccessPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IsOnSuccessPage implements Question<Boolean> {

    public static IsOnSuccessPage value() {
        return new IsOnSuccessPage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(SuccessPage.ORDER_PLACED_HEADING, isVisible()).forNoMoreThan(15).seconds()
        );
        return SuccessPage.ORDER_PLACED_HEADING.resolveFor(actor)
                .getText().equals("Your order has been placed!");
    }
}
