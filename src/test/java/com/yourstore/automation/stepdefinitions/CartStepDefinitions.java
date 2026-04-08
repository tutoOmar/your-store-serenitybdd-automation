package com.yourstore.automation.stepdefinitions;

import com.yourstore.automation.questions.CartDropdownIsVisible;
import com.yourstore.automation.questions.CartItemCount;
import com.yourstore.automation.questions.IsConfirmOrderVisible;
import com.yourstore.automation.questions.GuestCheckoutFormVisible;
import com.yourstore.automation.questions.IsOnCartPage;
import com.yourstore.automation.questions.IsOnSuccessPage;
import com.yourstore.automation.questions.IsPaymentMethodVisible;
import com.yourstore.automation.tasks.AcceptPaymentAndContinue;
import com.yourstore.automation.tasks.AddProductToCart;
import com.yourstore.automation.tasks.ConfirmOrder;
import com.yourstore.automation.tasks.ContinueDeliveryMethod;
import com.yourstore.automation.tasks.FillGuestCheckoutForm;
import com.yourstore.automation.tasks.OpenCartDropdown;
import com.yourstore.automation.tasks.SelectGuestCheckout;
import com.yourstore.automation.tasks.ViewCart;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CartStepDefinitions {

    @Before
    public void setUpStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void tearDown() {
        try {
            Serenity.getDriver().navigate().to("http://opencart.abstracta.us/");
            Serenity.getDriver().manage().deleteAllCookies();
            Serenity.getDriver().navigate().refresh();
        } catch (Exception ignored) {
        }
    }

    @Given("the user is on the home page")
    public void userOnHomePage() {
        OnStage.theActorCalled("User").attemptsTo(
                Open.url("http://opencart.abstracta.us/"));
    }

    @When("he adds products to the cart")
    public void addProduct() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            AddProductToCart.fromHomePage(1),
            AddProductToCart.fromHomePage(2)
        );
    }

    @Then("the cart should contain {int} products")
    public void validateCart(int expectedCount) {
        OnStage.theActorInTheSpotlight().should(
            seeThat(CartItemCount.value(), equalTo(expectedCount))
        );
    }

    @And("he opens the cart dropdown")
    public void openCartDropdown() {
        OnStage.theActorInTheSpotlight().attemptsTo(OpenCartDropdown.fromHeader());
    }

    @When("he clicks on view cart")
    public void clickViewCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(ViewCart.fromDropdown());
    }

    @Then("he should be on the cart page")
    public void validateOnCartPage() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(IsOnCartPage.value(), org.hamcrest.Matchers.is(true))
        );
    }

    @When("he proceeds as guest checkout")
    public void proceedAsGuest() {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectGuestCheckout.onCheckoutPage());
    }

    @Then("the guest checkout form should be visible")
    public void validateGuestCheckoutForm() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(GuestCheckoutFormVisible.value(), org.hamcrest.Matchers.is(true))
        );
    }

    @Then("the cart dropdown should be visible")
    public void validateCartDropdownIsVisible() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(CartDropdownIsVisible.value(), org.hamcrest.Matchers.is(true))
        );
    }

    @When("he fills the form with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void fillGuestForm(String firstName, String lastName, String email,
                               String telephone, String address, String city,
                               String postcode, String country, String zone) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            FillGuestCheckoutForm.with(firstName, lastName, email, telephone, address, city, postcode, country, zone)
        );
    }

    @Then("the guest checkout form should not be visible")
    public void validateGuestFormSubmitted() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(GuestCheckoutFormVisible.value(), org.hamcrest.Matchers.is(false))
        );
    }

    @When("he continues with the delivery method")
    public void continueDeliveryMethod() {
        OnStage.theActorInTheSpotlight().attemptsTo(ContinueDeliveryMethod.onCheckoutPage());
    }

    @Then("the payment method section should be visible")
    public void validatePaymentMethodVisible() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(IsPaymentMethodVisible.value(), org.hamcrest.Matchers.is(true))
        );
    }

    @When("he accepts the payment method")
    public void acceptPaymentMethod() {
        OnStage.theActorInTheSpotlight().attemptsTo(AcceptPaymentAndContinue.onCheckoutPage());
    }

    @Then("the confirm order section should be visible")
    public void validateConfirmOrderVisible() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(IsConfirmOrderVisible.value(), org.hamcrest.Matchers.is(true))
        );
    }

    @When("he confirms the order")
    public void confirmOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConfirmOrder.onCheckoutPage());
    }

    @Then("he should be on the success page")
    public void validateOnSuccessPage() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(IsOnSuccessPage.value(), org.hamcrest.Matchers.is(true))
        );
    }
}
