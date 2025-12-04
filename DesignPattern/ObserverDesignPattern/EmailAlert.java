package DesignPattern.ObserverDesignPattern;

/**
 * Another Concrete Observer.
 */
public class EmailAlert implements Observer {

    @Override
    public void update(int newPrice) {
        System.out.println("EMAIL ALERT: New stock price = " + newPrice);
    }
}
