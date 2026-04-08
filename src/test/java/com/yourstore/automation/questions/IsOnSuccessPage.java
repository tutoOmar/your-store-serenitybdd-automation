package com.yourstore.automation.questions;

import com.yourstore.automation.ui.SuccessPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IsOnSuccessPage implements Question<Boolean> {

    public static IsOnSuccessPage value() {
        return new IsOnSuccessPage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SuccessPage.ORDER_PLACED_HEADING.resolveFor(actor)
                .getText().equals("Your order has been placed!");
    }
}
