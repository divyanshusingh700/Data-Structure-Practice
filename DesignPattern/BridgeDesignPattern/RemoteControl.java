package DesignPattern.BridgeDesignPattern;

/**
 * RemoteControl.java
 *
 * Abstraction in the Bridge pattern.
 * Holds a reference to a Device (implementor) and delegates low-level
 * operations to it. This class is non-abstract so it can be used directly,
 * but it could also be made abstract if some implementations should provide
 * different high-level behavior.
 */
public class RemoteControl {
    /**
     * The implementor reference. Composition creates the Bridge.
     */
    protected Device device;

    /**
     * Constructor injects the concrete implementor.
     * @param device a concrete device that implements Device
     */
    public RemoteControl(Device device) {
        this.device = device;
    }

    /**
     * Toggle power: if the device is on, turn it off; otherwise turn it on.
     */
    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    /**
     * Increase volume by 10 percentage points.
     */
    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    /**
     * Decrease volume by 10 percentage points.
     */
    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }
}
