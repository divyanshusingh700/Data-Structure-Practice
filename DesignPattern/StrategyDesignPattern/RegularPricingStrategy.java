package DesignPattern.StrategyDesignPattern;

/**
 * RegularPricingStrategy.java
 *
 * No-discount strategy: price = baseCost * quantity.
 */
public class RegularPricingStrategy implements PricingStrategy {

    @Override
    public int calculatePrice(Pizza pizza, int quantity) {
        return pizza.getBaseCostInCents() * quantity;
    }
}
