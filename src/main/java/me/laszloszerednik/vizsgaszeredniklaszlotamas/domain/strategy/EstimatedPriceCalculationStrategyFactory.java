package me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.strategy;


public abstract class EstimatedPriceCalculationStrategyFactory {
     public static EstimatedPriceCalculationStrategy createStrategy(String strategy) {
        return switch (strategy) {
            case "default" -> new DefaultEstimatedPriceCalculationStrategy();
            case "quantityRatioPrioritizing" -> new QuantityRatioPrioritizingEstimatedPriceCalculationStrategy();
            default -> throw new IllegalStateException("Unexpected strategy: " + strategy);
        };
    }
}
