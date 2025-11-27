package DesignPattern.DecoratorPattern;

/**
 * Pizza.java
 *
 * Abstract Component in the Decorator pattern.
 * Represents the concept of a pizza: it must provide a description and a cost.
 *
 * We use 'abstract' because there is no generic pizza instance to create - concrete
 * subclasses must implement the behavior.
 */
public abstract class Pizza {
    /**
     * Returns a human-readable description of this pizza including its toppings.
     * @return pizza description
     */
    public abstract String getDescription();

    /**
     * Returns the cost in cents (integer currency) for easier arithmetic.
     * @return cost in cents
     */
    public abstract int getCost();
}
