package com.yourstore.automation.questions;

import com.yourstore.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.Text.of;

public class CartItemCount implements Question<Integer> {

    private static final Pattern ITEM_COUNT_PATTERN = Pattern.compile("(\\d+)\\s+item\\(s\\)");

    public static Question<Integer> value() {
        return new CartItemCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        actor.attemptsTo(
            WaitUntil.the(HomePage.CART_TOTAL, containsText("item(s)"))
                     .forNoMoreThan(5).seconds()
        );
        String cartText = of(HomePage.CART_TOTAL).answeredBy(actor);
        Matcher matcher = ITEM_COUNT_PATTERN.matcher(cartText);
        return matcher.find() ? Integer.parseInt(matcher.group(1)) : 0;
    }
}
