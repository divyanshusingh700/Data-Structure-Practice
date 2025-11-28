package DesignPattern.StrategyDesignPattern;
/**
 * PricingStrategy.java
 *
 * The Strategy interface. Each concrete implementation encapsulates a pricing algorithm.
 *
 * It returns final price in cents for a given pizza and quantity.
 */
public interface PricingStrategy {
    /**
     * Calculate final price for the given pizza and quantity.
     *
     * @param pizza the pizza being ordered
     * @param quantity how many pizzas
     * @return total price in cents
     */
    int calculatePrice(Pizza pizza, int quantity);
}

