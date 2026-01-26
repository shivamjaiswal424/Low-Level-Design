package org.example;

public class Expression implements ArithmeticExpression{
    public ArithmeticExpression leftExpression;
    public ArithmeticExpression rightExpression;
    public OperationType operationType;
    public Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, OperationType operationType) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operationType = operationType;

    }
    @Override
    public int evaluate() {
        int value=0;
        switch (operationType){
            case ADD:
                value=leftExpression.evaluate()+rightExpression.evaluate();
                break;
            case SUB:
                value=leftExpression.evaluate()-rightExpression.evaluate();
                break;
            case MUL:
                value=leftExpression.evaluate()*rightExpression.evaluate();
                break;
            case DIV:
                value=leftExpression.evaluate()/rightExpression.evaluate();
                break;
        }
        System.out.println("Evaluating Number: "+ value);
        return value;
    }
}
