package org.example.shapes;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square:: draw");
    }

    @Override
    public void computeShape() {
        System.out.println("Inside Square:: computeShape");
    }
}
