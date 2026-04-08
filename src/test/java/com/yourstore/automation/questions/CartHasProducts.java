package com.yourstore.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.Text.of;

public class CartHasProducts implements Question<Boolean> {

    private static final Target CART_TOTAL = Target.the("cart total in header")
            .locatedBy("#cart-total");

    public static CartHasProducts value() {
        return new CartHasProducts();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
            WaitUntil.the(CART_TOTAL, containsText("item(s)"))
                     .forNoMoreThan(5).seconds()
        );
        String cartText = of(CART_TOTAL).answeredBy(actor);
        return cartText != null && !cartText.startsWith("0");
    }
}