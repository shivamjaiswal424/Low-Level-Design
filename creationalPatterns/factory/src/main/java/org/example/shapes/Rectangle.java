package org.example.shapes;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle:: draw");
    }

    @Override
    public void computeShape() {
        System.out.println("Inside Rectangle:: computeShape ");
    }
}
