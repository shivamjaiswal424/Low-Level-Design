package org.example.factorymethod;

import org.example.shapes.Shape;
import org.example.shapes.Square;

public class SquareCreator extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Square();
    }
}
