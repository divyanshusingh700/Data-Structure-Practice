package DesignPattern.StrategyDesignPattern;
/**
 * BuyOneGetOneStrategy.java
 *
 * Special strategy: buy one get one free.
 * For odd quantities, the last one is charged normally.
 *
 * Example: quantity=1 -> pay for 1
 *          quantity=2 -> pay for 1
 *          quantity=3 -> pay for 2
 */
public class BuyOneGetOneStrategy implements PricingStrategy {

    @Override
    public int calculatePrice(Pizza pizza, int quantity) {
        int payable = (quantity / 2) + (quantity % 2);
        return pizza.getBaseCostInCents() * payable;
    }
}
