package DesignPattern.BridgeDesignPattern;

/**
 * BridgeDesign.java
 *
 * Small client that composes Remotes with Devices to demonstrate Bridge usage.
 */
public class BridgeDesign {
    public static void main(String[] args) {
        // Compose a RemoteControl with a TV implementor
        Device tv = new TV();
        RemoteControl remote = new RemoteControl(tv);
        remote.togglePower(); // should power on TV
        remote.volumeUp();    // increase TV volume
        remote.volumeUp();    // increase TV volume
        remote.togglePower(); // power off TV

        System.out.println("----");

        // Compose an AdvancedRemote with a Radio implementor
        Device radio = new Radio();
        AdvancedRemote advRemote = new AdvancedRemote(radio);
        advRemote.togglePower();               // power on Radio
        advRemote.powerOnWithVolume(50); // ensure volume set to 50%
        advRemote.mute(); // mute Radio
    }
}

