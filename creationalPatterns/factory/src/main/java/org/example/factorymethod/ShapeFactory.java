package org.example.factorymethod;

import org.example.shapes.Shape;
import org.example.shapes.ShapeType;

public abstract class ShapeFactory {
    public abstract Shape createShape();
}
