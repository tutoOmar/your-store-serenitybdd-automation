package com.yourstore.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.actions.Click.on;

import com.yourstore.automation.ui.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductToCart implements Task {
    
    public static AddProductToCart fromHomePage() {
        return instrumented(AddProductToCart.class);
    }
    
    @Override
    public String toString() {
        return "adds a product to the cart";
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            on(HomePage.ADD_TO_CART_FIRST_PRODUCT));
    }
}