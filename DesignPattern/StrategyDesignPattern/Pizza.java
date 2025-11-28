package DesignPattern.StrategyDesignPattern;

/**
 * Pizza.java
 *
 * Abstract representation of a pizza. This is an abstract class because a generic
 * pizza concept should not be instantiated directly — concrete pizzas provide details.
 *
 * The Strategy pattern will be used to compute price externally, so Pizza only
 * exposes a base cost and description.
 */
public abstract class Pizza {
    /**
     * Returns a human-readable description of this pizza.
     * e.g., "Plain pizza (thin crust)"
     */
    public abstract String getDescription();

    /**
     * Base cost in cents (e.g., 500 for $5.00). Concrete pizzas provide this.
     */
    public abstract int getBaseCostInCents();
}
