package DesignPattern.AdapterDesignPattern;
// Adapter converts the interface of one class into another interface that clients expect. 
// It lets classes with incompatible interfaces collaborate without modifying existing code. 
// It is commonly used when integrating legacy systems or third-party libraries. 
// It acts like a translator. Implementation uses composition to wrap the adaptee.

// Why do we need Adapter?
// You use Adapter when:
    // You want to use a class but its interface does not match your expectation.
    // You cannot modify the existing class (3rd party library, legacy code).
    // You want clients to work with a consistent interface.

//  Types of Adapter Pattern
    //  Object Adapter (most common)
        // Uses composition
        // Adapter holds reference to Adaptee object
        // More flexible

    // Class Adapter (multiple inheritance)
        // Uses extends Adaptee + implements Target
        // Only possible via multiple inheritance (not in Java).
        // Java can simulate via interface extension, but object adapter is preferred.
public class AdapterDesign {
    
    public static void main(String[] args) {

        Shape rectangle = new RectangleAdapter(new LegacyRectangle());
        rectangle.draw();  // Works even though legacy class has different format
    }
}
