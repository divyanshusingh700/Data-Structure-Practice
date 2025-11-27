package DesignPattern.DecoratorPattern;

/**
 * OlivesDecorator.java
 *
 * Concrete Decorator: adds olives topping.
 */
public class OlivesDecorator extends PizzaDecorator {

    public OlivesDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    /**
     * Cost for olives: 60 cents
     */
    @Override
    public int getCost() {
        return pizza.getCost() + 60;
    }
}
