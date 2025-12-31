package org.example;

public abstract class ToppingDecorator implements BasePizza {
    BasePizza pizza;
    public ToppingDecorator(BasePizza pizza){
        this.pizza=pizza;
    }
}
