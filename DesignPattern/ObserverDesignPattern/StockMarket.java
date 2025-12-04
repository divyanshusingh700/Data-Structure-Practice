package DesignPattern.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject: maintains stock price and notifies observers.
 */
public class StockMarket implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private int stockPrice;

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    /**
     * Notify all observers about price change
     */
    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(stockPrice);
        }
    }

    /**
     * When stock price changes, notify all observers.
     */
    public void setStockPrice(int newPrice) {
        this.stockPrice = newPrice;
        notifyObservers();
    }
}
