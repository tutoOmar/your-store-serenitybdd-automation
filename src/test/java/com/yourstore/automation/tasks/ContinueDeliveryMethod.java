package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContinueDeliveryMethod implements Task {

    public static ContinueDeliveryMethod onCheckoutPage() {
        return instrumented(ContinueDeliveryMethod.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.DELIVERY_CONTINUE_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                on(CheckoutPage.DELIVERY_CONTINUE_BUTTON),
                WaitUntil.the(CheckoutPage.PAYMENT_METHOD_RADIO, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}
