package DesignPattern.ObserverDesignPattern;

/**
 * Concrete Observer: receives updates from StockMarket.
 */
public class MobileApp implements Observer {

    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(int newPrice) {
        System.out.println(name + " received stock update: " + newPrice);
    }
}
