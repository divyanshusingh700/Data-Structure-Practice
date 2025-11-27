package DesignPattern.DecoratorPattern;

/**
 * CheeseDecorator.java
 *
 * Concrete Decorator: adds cheese topping.
 */
public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    /**
     * Cost for cheese: 80 cents
     */
    @Override
    public int getCost() {
        return pizza.getCost() + 80;
    }
}
