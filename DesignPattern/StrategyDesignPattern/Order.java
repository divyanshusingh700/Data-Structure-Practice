package DesignPattern.StrategyDesignPattern;

/**
 * Order.java
 *
 * Represents an order: pizza, quantity, and strategy used to compute bill.
 * Demonstrates how client code can choose different strategies at runtime.
 */
public class Order {
    private final Pizza pizza;
    private final int quantity;
    private PricingStrategy pricingStrategy;

    public Order(Pizza pizza, int quantity, PricingStrategy pricingStrategy) {
        if (quantity < 1) throw new IllegalArgumentException("quantity >= 1");
        this.pizza = pizza;
        this.quantity = quantity;
        this.pricingStrategy = pricingStrategy;
    }

    /**
     * Allows changing the pricing strategy at runtime.
     */
    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    /**
     * Compute total in cents using current strategy.
     */
    public int computeTotalInCents() {
        return pricingStrategy.calculatePrice(pizza, quantity);
    }

    public String getDescription() {
        return pizza.getDescription() + " x" + quantity;
    }
}

