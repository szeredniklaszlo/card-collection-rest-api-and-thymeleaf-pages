package me.laszloszerednik.vizsgaszeredniklaszlotamas.domain;

import lombok.Data;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.strategy.EstimatedPriceCalculationStrategy;

@Data
public class Card {
    private Long id;
    private String name;
    private String type;
    private Double quantityRatio;
    private Integer obtainPrice;
    private Integer obtainYear;
    private Integer releaseYear;
    private Integer releasePrice;
    private Kollection collection;

    public Double calculateEstimatedPrice(EstimatedPriceCalculationStrategy calculationStrategy) {
        return calculationStrategy.calculate(this);
    }
}
