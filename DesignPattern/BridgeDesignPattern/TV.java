package DesignPattern.BridgeDesignPattern;

/**
 * TV.java
 *
 * ConcreteImplementor: a concrete device implementation.
 * Simulates a television device with on/off and volume controls.
 */
public class TV implements Device {
    private boolean on = false;
    private int volume = 30;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("TV: powered ON");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("TV: powered OFF");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        // clamp between 0 and 100
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("TV: volume set to " + volume + "%");
    }
}

