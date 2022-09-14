package me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.strategy;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;

public interface EstimatedPriceCalculationStrategy {
    Double calculate(Card card, int currentYear);
}
