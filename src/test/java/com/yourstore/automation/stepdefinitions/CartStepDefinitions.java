package com.yourstore.automation.stepdefinitions;

import com.yourstore.automation.questions.CartItemCount;
import com.yourstore.automation.tasks.AddProductToCart;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
}
