package DesignPattern.StrategyDesignPattern;

/**
 * BulkDiscountStrategy.java
 *
 * If quantity >= threshold, apply a flat percent discount to the whole order.
 * Otherwise charge regular price.
 */
public class BulkDiscountStrategy implements PricingStrategy {

    private final int threshold;
    private final int discountPercent;

    /**
     * @param threshold number of pizzas to qualify for discount (e.g., 3)
     * @param discountPercent percent off when threshold met (0..100)
     */
    public BulkDiscountStrategy(int threshold, int discountPercent) {
        if (threshold < 1) throw new IllegalArgumentException("threshold >= 1");
        if (discountPercent < 0 || discountPercent > 100)
            throw new IllegalArgumentException("discountPercent must be 0..100");
        this.threshold = threshold;
        this.discountPercent = discountPercent;
    }

    @Override
    public int calculatePrice(Pizza pizza, int quantity) {
        int total = pizza.getBaseCostInCents() * quantity;
        if (quantity >= threshold) {
            int discount = total * discountPercent / 100;
            return total - discount;
        }
        return total;
    }
}

