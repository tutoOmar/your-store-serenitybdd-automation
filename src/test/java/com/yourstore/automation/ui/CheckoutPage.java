package com.yourstore.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static final Target GUEST_CHECKOUT_RADIO = Target.the("guest checkout radio button")
            .locatedBy("css:input[name='account'][value='guest']");

    public static final Target CONTINUE_BUTTON = Target.the("continue button on checkout options")
            .locatedBy("css:#button-account");

    public static final Target FIRST_NAME_INPUT = Target.the("first name input in billing form")
            .locatedBy("css:#input-payment-firstname");

    public static final Target LAST_NAME_INPUT = Target.the("last name input in billing form")
            .locatedBy("css:#input-payment-lastname");

    public static final Target EMAIL_INPUT = Target.the("email input in billing form")
            .locatedBy("css:#input-payment-email");

    public static final Target TELEPHONE_INPUT = Target.the("telephone input in billing form")
            .locatedBy("css:#input-payment-telephone");

    public static final Target ADDRESS_INPUT = Target.the("address input in billing form")
            .locatedBy("css:#input-payment-address-1");

    public static final Target CITY_INPUT = Target.the("city input in billing form")
            .locatedBy("css:#input-payment-city");

    public static final Target POSTCODE_INPUT = Target.the("postcode input in billing form")
            .locatedBy("css:#input-payment-postcode");

    public static final Target ZONE_SELECT = Target.the("region/state select in billing form")
            .locatedBy("css:#input-payment-zone");

    public static final Target COUNTRY_SELECT = Target.the("country select in billing form")
            .locatedBy("css:#input-payment-country");

    public static final Target CONTINUE_BILLING_BUTTON = Target.the("continue button on billing form")
            .locatedBy("css:#button-guest");

    private CheckoutPage() {
    }
}
