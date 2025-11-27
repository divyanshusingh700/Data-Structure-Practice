package DesignPattern.BridgeDesignPattern;

/**
 * Device.java
 *
 * Implementor interface in the Bridge pattern.
 * Represents a generic electronic device that can be powered on/off and has volume control.
 *
 * This is an interface because it declares a contract (what operations are required)
 * but does not provide any implementation. Concrete devices (TV, Radio, etc.)
 * implement this interface.
 */
public interface Device {
    /**
     * Check whether the device is enabled (powered on).
     * @return true if device is enabled, false otherwise
     */
    boolean isEnabled();

    /**
     * Power on the device.
     */
    void enable();

    /**
     * Power off the device.
     */
    void disable();

    /**
     * Get current volume as integer percent (0-100).
     * @return current volume
     */
    int getVolume();

    /**
     * Set volume as integer percent (0-100).
     * Implementors should clamp the value to the valid range.
     * @param percent new volume
     */
    void setVolume(int percent);
}
