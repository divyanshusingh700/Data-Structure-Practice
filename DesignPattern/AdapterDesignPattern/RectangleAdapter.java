package DesignPattern.AdapterDesignPattern;

/**
 * Adapts LegacyRectangle to the Shape interface.
 */
public class RectangleAdapter implements Shape {

    private LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw() {
        // Convert Shape's draw() call to legacy method signature
        legacyRectangle.drawLegacy(0, 0, 10, 20);
    }
}

