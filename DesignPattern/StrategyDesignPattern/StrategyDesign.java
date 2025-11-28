package DesignPattern.StrategyDesignPattern;

/**
 * StrategyDesign.java
 *
 * Demonstrates Strategy pattern by computing order totals with different strategies.
 */
public class StrategyDesign {
    public static void main(String[] args) {
        Pizza plain = new PlainPizza();          // base $5.00
        Pizza cheese = new CheesePizza();        // base $5.80

        // Create strategies
        PricingStrategy regular = new RegularPricingStrategy();
        PricingStrategy tenPercent = new PercentageDiscountStrategy(10);
        PricingStrategy bulk3_15 = new BulkDiscountStrategy(3, 15); // 15% off if 3+
        PricingStrategy bogo = new BuyOneGetOneStrategy();

        // Orders
        Order o1 = new Order(plain, 1, regular);
        printOrder(o1);

        Order o2 = new Order(cheese, 2, tenPercent);
        printOrder(o2);

        Order o3 = new Order(plain, 4, bulk3_15);
        printOrder(o3);

        Order o4 = new Order(plain, 3, bogo);
        printOrder(o4);

        // Demonstrate switching strategy at runtime
        Order o5 = new Order(cheese, 5, regular);
        System.out.println("Before switching strategy:");
        printOrder(o5);
        o5.setPricingStrategy(bulk3_15);
        System.out.println("After switching strategy to bulk discount:");
        printOrder(o5);
    }

    static void printOrder(Order o) {
        System.out.println("Order: " + o.getDescription());
        System.out.printf("Total: $%.2f%n", o.computeTotalInCents() / 100.0);
        System.out.println("--------");
    }
}
