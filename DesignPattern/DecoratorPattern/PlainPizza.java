package DesignPattern.DecoratorPattern;

/**
 * PlainPizza.java
 *
 * ConcreteComponent: a simple pizza base with cheese-less default (or minimal).
 * This is the simplest pizza you can order; decorators add toppings and cost.
 */
public class PlainPizza extends Pizza {

    @Override
    public String getDescription() {
        return "Plain pizza (thin crust)";
    }

    /**
     * Base cost: 500 cents ($5.00)
     */
    @Override
    public int getCost() {
        return 500;
    }
}

