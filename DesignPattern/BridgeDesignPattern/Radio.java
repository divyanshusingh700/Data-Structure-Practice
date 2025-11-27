package DesignPattern.BridgeDesignPattern;

/**
 * Radio.java
 *
 * ConcreteImplementor: another concrete device implementation.
 * Simulates a radio device.
 */
public class Radio implements Device {
    private boolean on = false;
    private int volume = 10;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("Radio: powered ON");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Radio: powered OFF");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("Radio: volume set to " + volume + "%");
    }
}
