package com.yourstore.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.questions.Text.of;

public class CartHasProducts implements Question<Boolean> {

    private static final Target CART_TOTAL = Target.the("cart total in header")
            .locatedBy("#cart-total");

    public static CartHasProducts value() {
        return new CartHasProducts();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String cartText = of(CART_TOTAL).answeredBy(actor);
        return cartText != null && !cartText.startsWith("0");
    }
}