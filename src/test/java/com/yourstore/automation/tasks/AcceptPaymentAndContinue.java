package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AcceptPaymentAndContinue implements Task {

    public static AcceptPaymentAndContinue onCheckoutPage() {
        return instrumented(AcceptPaymentAndContinue.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.AGREE_CHECKBOX, isVisible()).forNoMoreThan(10).seconds(),
                on(CheckoutPage.AGREE_CHECKBOX),
                on(CheckoutPage.PAYMENT_CONTINUE_BUTTON)
        );
    }
}
