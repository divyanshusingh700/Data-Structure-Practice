package DesignPattern.DecoratorPattern;

/**
 * PizzaDecorator.java
 *
 * Abstract Decorator: extends Pizza and wraps another Pizza instance.
 * Using 'abstract' because it's a forwarding class intended to be subclassed.
 */
public abstract class PizzaDecorator extends Pizza {
    protected final Pizza pizza; // the wrapped pizza component

    /**
     * Constructor injects the pizza to be decorated.
     * @param pizza pizza to wrap
     */
    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    // default implementations forward to wrapped pizza.
    // Concrete decorators will override these methods to add behaviour.
    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public int getCost() {
        return pizza.getCost();
    }
}

