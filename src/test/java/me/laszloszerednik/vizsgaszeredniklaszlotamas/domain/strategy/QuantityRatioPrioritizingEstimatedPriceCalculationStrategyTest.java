package me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.strategy;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuantityRatioPrioritizingEstimatedPriceCalculationStrategyTest {
    private QuantityRatioPrioritizingEstimatedPriceCalculationStrategy strategy;

    @BeforeEach
    public void initialize() {
        strategy = new QuantityRatioPrioritizingEstimatedPriceCalculationStrategy();
    }

    @Test
    public void calculateTest() {
        int currentYear = 2000;
        Card card = new Card();
        card.setReleasePrice(10000);
        card.setReleaseYear(1990);
        card.setQuantityRatio(50d);

        assertEquals(100000, strategy.calculate(card, currentYear), 0.001);
    }
}
