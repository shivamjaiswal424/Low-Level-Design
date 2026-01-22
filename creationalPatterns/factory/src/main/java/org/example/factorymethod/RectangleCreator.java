package org.example.factorymethod;

import org.example.shapes.Rectangle;
import org.example.shapes.Shape;

public class RectangleCreator extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
