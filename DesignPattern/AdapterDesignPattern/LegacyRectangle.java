package DesignPattern.AdapterDesignPattern;

public class LegacyRectangle {

    public void drawLegacy(int x1, int y1, int x2, int y2) {
        System.out.println("Drawing old rectangle from (" + x1 + "," + y1 +
                ") to (" + x2 + "," + y2 + ")");
    }
}

