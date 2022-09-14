package me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.strategy;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultEstimatedPriceCalculationStrategyTests {
    private DefaultEstimatedPriceCalculationStrategy strategy;

    @BeforeEach
    public void initialize() {
        strategy = new DefaultEstimatedPriceCalculationStrategy();
    }

    @Test
    public void calculateTest() {
        int currentYear = 2000;
        Card card = new Card();
        card.setReleasePrice(10000);
        card.setReleaseYear(1990);

        assertEquals(110000, strategy.calculate(card, currentYear), 0.001);
    }
}
