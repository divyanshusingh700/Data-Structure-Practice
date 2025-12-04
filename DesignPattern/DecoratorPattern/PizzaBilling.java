package DesignPattern.DecoratorPattern;

/**
 * PizzaBilling.java
 *
 * Demonstrates using decorators to build pizza orders and compute bills.
 */
public class PizzaBilling {
    public static void main(String[] args) {
        // 1) Simple plain pizza
        Pizza p1 = new PlainPizza();
        printBill(p1);

        // 2) Plain pizza with cheese and olives
        Pizza p2 = new OlivesDecorator(new CheeseDecorator(new PlainPizza()));
        printBill(p2);

        // 3) Fancy pizza: base + cheese + pepperoni + extra cheese
        Pizza p3 = new ExtraCheeseDecorator(new PepperoniDecorator(new CheeseDecorator(new PlainPizza())));
        printBill(p3);

        // 4) Demonstrate dynamic decorating (starting with base, add toppings)
        Pizza dynamic = new PlainPizza();
        dynamic = new CheeseDecorator(dynamic);      // add cheese
        dynamic = new PepperoniDecorator(dynamic);   // add pepperoni
        dynamic = new OlivesDecorator(dynamic);      // add olives
        printBill(dynamic);
    }

    private static void printBill(Pizza pizza) {
        System.out.println("Order: " + pizza.getDescription());
        System.out.printf("Total: $%.2f%n", pizza.getCost() / 100.0);
        System.out.println("--------");
    }
}
