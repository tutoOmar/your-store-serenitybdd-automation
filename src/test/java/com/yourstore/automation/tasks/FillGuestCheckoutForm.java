package com.yourstore.automation.tasks;

import com.yourstore.automation.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class FillGuestCheckoutForm implements Task {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String telephone;
    private final String address;
    private final String city;
    private final String postcode;
    private final String country;
    private final String zone;

    public FillGuestCheckoutForm(String firstName, String lastName, String email,
                                  String telephone, String address, String city,
                                  String postcode, String country, String zone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.zone = zone;
    }

    public static FillGuestCheckoutForm with(String firstName, String lastName, String email,
                                              String telephone, String address, String city,
                                              String postcode, String country, String zone) {
        return instrumented(FillGuestCheckoutForm.class,
                firstName, lastName, email, telephone, address, city, postcode, country, zone);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                theValue(firstName).into(CheckoutPage.FIRST_NAME_INPUT),
                theValue(lastName).into(CheckoutPage.LAST_NAME_INPUT),
                theValue(email).into(CheckoutPage.EMAIL_INPUT),
                theValue(telephone).into(CheckoutPage.TELEPHONE_INPUT),
                theValue(address).into(CheckoutPage.ADDRESS_INPUT),
                theValue(city).into(CheckoutPage.CITY_INPUT),
                theValue(postcode).into(CheckoutPage.POSTCODE_INPUT),
                SelectFromOptions.byVisibleText(country).from(CheckoutPage.COUNTRY_SELECT),
                WaitUntil.the(CheckoutPage.ZONE_SELECT, containsText(zone)).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(zone).from(CheckoutPage.ZONE_SELECT),
                on(CheckoutPage.CONTINUE_BILLING_BUTTON),
                WaitUntil.the(CheckoutPage.CONTINUE_BILLING_BUTTON, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }
}
