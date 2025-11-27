package DesignPattern.DecoratorPattern;

/**
 * PepperoniDecorator.java
 *
 * Concrete Decorator: adds pepperoni topping.
 */
public class PepperoniDecorator extends PizzaDecorator {

    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    /**
     * Cost for pepperoni: 120 cents
     */
    @Override
    public int getCost() {
        return pizza.getCost() + 120;
    }
}
