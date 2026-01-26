package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Composite Design Pattern");
        ArithmeticExpression two=new Number(2) ;
        ArithmeticExpression three=new Number(3) ;
        ArithmeticExpression four=new Number(4) ;
        ArithmeticExpression addExpression=new Expression(three,four,OperationType.ADD);
        ArithmeticExpression parentExpression=new Expression(two,addExpression,OperationType.MUL);
        System.out.println(parentExpression.evaluate());
    }
}