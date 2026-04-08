package com.yourstore.automation.questions;

import com.yourstore.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CartDropdownIsVisible implements Question<Boolean> {

    public static CartDropdownIsVisible value() {
        return new CartDropdownIsVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return HomePage.CART_DROPDOWN_MENU.resolveFor(actor).isVisible();
    }
}
