package me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.strategy;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;

import java.time.LocalDate;

public class DefaultEstimatedPriceCalculationStrategy implements EstimatedPriceCalculationStrategy {
    @Override
    public Double calculate(Card card, int currentYear) {
        return card.getReleasePrice() * (currentYear - card.getReleaseYear()) * 1.1;
    }
}
