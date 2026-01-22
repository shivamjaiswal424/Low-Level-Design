package org.example.factorymethod;

import org.example.shapes.Circle;
import org.example.shapes.Shape;

public class CircleCreator extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Circle();
    }
}
