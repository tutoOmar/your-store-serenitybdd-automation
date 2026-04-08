package com.yourstore.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class IsOnCartPage implements Question<Boolean> {

    public static IsOnCartPage value() {
        return new IsOnCartPage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        return currentUrl != null && currentUrl.contains("route=checkout/cart");
    }
}
