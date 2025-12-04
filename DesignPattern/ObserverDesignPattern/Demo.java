package DesignPattern.ObserverDesignPattern;

/**
 * Demo to show Observer pattern in action.
 */
public class Demo {
    public static void main(String[] args) {

        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp("MobileApp1");
        Observer email = new EmailAlert();

        market.register(mobile);
        market.register(email);

        market.setStockPrice(100);
        market.setStockPrice(120);

        market.unregister(mobile);

        market.setStockPrice(130);  // Only email receives this update
    }
}

