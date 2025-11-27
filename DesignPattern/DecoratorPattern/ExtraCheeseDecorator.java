package DesignPattern.DecoratorPattern;

/**
 * ExtraCheeseDecorator.java
 *
 * Concrete Decorator: adds extra cheese topping (different cost than regular cheese).
 */
public class ExtraCheeseDecorator extends PizzaDecorator {

    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    /**
     * Cost for extra cheese: 150 cents
     */
    @Override
    public int getCost() {
        return pizza.getCost() + 150;
    }
}
