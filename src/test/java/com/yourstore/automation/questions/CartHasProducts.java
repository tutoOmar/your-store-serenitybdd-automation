package com.yourstore.automation.questions;

import com.yourstore.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.questions.Text.of;

public class CartHasProducts implements Question<Boolean> {

    public static CartHasProducts value() {
        return new CartHasProducts();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String cartText = of(HomePage.CART_TOTAL).answeredBy(actor);
        return cartText != null && !cartText.startsWith("0");
    }
}