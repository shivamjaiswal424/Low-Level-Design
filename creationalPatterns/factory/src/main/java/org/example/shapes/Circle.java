package org.example.shapes;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public void computeShape() {
        System.out.println("Inside Circle:: computeShape ");
    }
}
