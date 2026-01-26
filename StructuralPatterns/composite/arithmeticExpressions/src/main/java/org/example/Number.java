package org.example;

public class Number implements ArithmeticExpression {
    public int value;
    public Number(int value) {
        this.value = value;
    }
    @Override
    public int evaluate() {
        System.out.println("Evaluating Number: "+ value);
        return value;

    }
}
