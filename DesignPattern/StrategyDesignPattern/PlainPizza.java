package DesignPattern.StrategyDesignPattern;

/**
 * PlainPizza.java
 *
 * A concrete Pizza implementation representing a basic pizza.
 */
public class PlainPizza extends Pizza {

    @Override
    public String getDescription() {
        return "Plain pizza (thin crust)";
    }

    @Override
    public int getBaseCostInCents() {
        return 500; // $5.00
    }
}

