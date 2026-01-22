package org.example.simplefactory;

import org.example.shapes.Shape;
import org.example.shapes.ShapeType;

public class ShapeFactoryDemo {
    public static void main(String[] args) {
        ShapeType shapeType = ShapeType.CIRCLE;
        Shape shape=ShapeFactory.createShape(shapeType);
        shape.draw();
        shape.computeShape();

    }
}
