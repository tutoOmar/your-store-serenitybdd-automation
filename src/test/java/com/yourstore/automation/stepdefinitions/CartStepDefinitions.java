package com.yourstore.automation.stepdefinitions;

import com.yourstore.automation.questions.CartHasProducts;
import com.yourstore.automation.tasks.AddProductToCart;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CartStepDefinitions {

    @Before
    public void setUpStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is on the home page")
    public void userOnHomePage() {
        OnStage.theActorCalled("User").attemptsTo(
                Open.url("http://opencart.abstracta.us/"));
    }

    @When("he adds a product to the cart")
    public void addProduct() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProductToCart.fromHomePage());
    }

    @Then("the cart should contain products")
    public void validateCart() {
        OnStage.theActorInTheSpotlight().should(seeThat(CartHasProducts.value()));
    }
}
