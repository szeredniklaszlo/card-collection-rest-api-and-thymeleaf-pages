package me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.strategy;

import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;

import java.time.LocalDate;

public class DefaultEstimatedPriceCalculationStrategy implements EstimatedPriceCalculationStrategy {
    @Override
    public Double calculate(Card card) {
        return card.getReleasePrice() * (LocalDate.now().getYear() - card.getReleaseYear()) * 1.1;
    }
}
