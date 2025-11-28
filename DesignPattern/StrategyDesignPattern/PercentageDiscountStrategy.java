package DesignPattern.StrategyDesignPattern;

/**
 * PercentageDiscountStrategy.java
 *
 * Applies a percentage discount (0-100) to the total price.
 * e.g., 10 means 10% off.
 */
public class PercentageDiscountStrategy implements PricingStrategy {

    private final int discountPercent;

    /**
     * @param discountPercent integer percent discount (0..100)
     */
    public PercentageDiscountStrategy(int discountPercent) {
        if (discountPercent < 0 || discountPercent > 100)
            throw new IllegalArgumentException("discountPercent must be 0..100");
        this.discountPercent = discountPercent;
    }

    @Override
    public int calculatePrice(Pizza pizza, int quantity) {
        int total = pizza.getBaseCostInCents() * quantity;
        int discount = total * discountPercent / 100;
        return total - discount;
    }
}
