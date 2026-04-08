package com.yourstore.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.actions.Click.on;

import com.yourstore.automation.ui.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductToCart implements Task {

    private final int index;

    public AddProductToCart(int index) {
        this.index = index;
    }

    public static AddProductToCart fromHomePage(int index) {
        return instrumented(AddProductToCart.class, index);
    }

    @Override
    public String toString() {
        return "adds product #" + index + " to the cart";
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            on(HomePage.addToCartButton(index)));
    }
}