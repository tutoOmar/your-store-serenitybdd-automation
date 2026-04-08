package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenCartDropdown implements Task {

    public static OpenCartDropdown fromHeader() {
        return instrumented(OpenCartDropdown.class);
    }

    @Override
    public String toString() {
        return "opens the cart dropdown from the header";
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            on(HomePage.CART_DROPDOWN_BUTTON),
            WaitUntil.the(HomePage.CART_TOTAL, isVisible()).forNoMoreThan(3).seconds()
        );
    }
}
