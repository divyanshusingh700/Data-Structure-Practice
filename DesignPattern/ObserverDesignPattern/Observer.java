package DesignPattern.ObserverDesignPattern;

/**
 * Observer interface.
 * Any subscriber must implement this method so it can receive updates.
 */
public interface Observer {
    void update(int newPrice);
}
