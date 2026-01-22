package org.example.factorymethod;

import org.example.shapes.Circle;
import org.example.shapes.Shape;
import org.example.shapes.ShapeType;


public class FactoryMethodDemo {
    public static void main(String[] args) {
        ShapeType shapeType = ShapeType.SQUARE;
        Shape shape=getShapeInstance(shapeType);
        shape.draw();
        shape.computeShape();
    }
    private static Shape getShapeInstance(ShapeType shapeType) {
        if (shapeType ==null) {
            return null;
        }
        Shape shape=null;
        switch (shapeType) {
            case CIRCLE:
                ShapeFactory circleCreator=new CircleCreator();
                shape=circleCreator.createShape();
                break;
            case SQUARE:
                ShapeFactory squareCreator=new SquareCreator();
                shape=squareCreator.createShape();
                break;

            case RECTANGLE:
                ShapeFactory rectangleCreator=new RectangleCreator();
                shape=rectangleCreator.createShape();
                break;
            default:
                throw new IllegalStateException("Shape type not found");

        }
        return shape;
    }
}
