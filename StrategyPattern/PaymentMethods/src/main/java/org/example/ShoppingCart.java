package org.example;

import org.example.strategy.PaymentStrategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    public void setShoppingCart(PaymentStrategy strategy){
        paymentStrategy=strategy;
    }
    public void checkout(double amount){
        System.out.println(this.paymentStrategy.getClass().getSimpleName()+ ": ");
        paymentStrategy.pay(amount);
    }
}
