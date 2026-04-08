package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.CheckoutPage;
import com.yourstore.automation.ui.SuccessPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmOrder implements Task {

    public static ConfirmOrder onCheckoutPage() {
        return instrumented(ConfirmOrder.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.CONFIRM_ORDER_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                on(CheckoutPage.CONFIRM_ORDER_BUTTON),
                WaitUntil.the(SuccessPage.ORDER_PLACED_HEADING, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}
