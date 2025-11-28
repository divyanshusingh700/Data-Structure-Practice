package DesignPattern.StrategyDesignPattern;

/**
 * CheesePizza.java
 *
 * A simple concrete pizza with cheese included as part of the base.
 */
public class CheesePizza extends Pizza {

    @Override
    public String getDescription() {
        return "Cheese pizza (thin crust)";
    }

    @Override
    public int getBaseCostInCents() {
        return 580; // $5.80 (base + cheese)
    }
}
