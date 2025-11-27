package DesignPattern.BridgeDesignPattern;

/**
 * AdvancedRemote.java
 *
 * RefinedAbstraction — extends RemoteControl with extra operations.
 * Demonstrates how the abstraction hierarchy can vary independently of the device.
 */
public class AdvancedRemote extends RemoteControl {

    /**
     * Pass through the Device to the parent constructor.
     * @param device concrete device implementor
     */
    public AdvancedRemote(Device device) {
        super(device);
    }

    /**
     * Convenience method to mute the device.
     */
    public void mute() {
        device.setVolume(0);
        System.out.println("AdvancedRemote: muted the device");
    }

    /**
     * Example of a higher-level operation that composes lower level calls.
     * It toggles power and then sets a preferred volume if turning on.
     * @param preferredVolume the preferred volume after turning on (0-100)
     */
    public void powerOnWithVolume(int preferredVolume) {
        if (!device.isEnabled()) {
            device.enable();
        }
        device.setVolume(preferredVolume);
        System.out.println("AdvancedRemote: powered on with volume " + preferredVolume + "%");
    }
}
