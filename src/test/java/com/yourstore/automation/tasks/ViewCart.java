package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Click.on;

public class ViewCart implements Task {

    public static ViewCart fromDropdown() {
        return instrumented(ViewCart.class);
    }

    @Override
    public String toString() {
        return "views the cart from the mini cart dropdown";
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(on(HomePage.VIEW_CART_BUTTON));
    }
}
