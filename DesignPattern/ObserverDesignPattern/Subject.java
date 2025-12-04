package DesignPattern.ObserverDesignPattern;

/**
 * Subject interface.
 * Allows observers to register, unregister, and be notified.
 */
public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
