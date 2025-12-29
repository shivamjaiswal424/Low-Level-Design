package org.example;

import org.example.strategy.CreditCardPayment;
import org.example.strategy.PayPalPayment;
import org.example.strategy.UPIPayment;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            System.out.println("Strategy Design Pattern");

            ShoppingCart cart=new ShoppingCart();
            cart.setShoppingCart(new PayPalPayment("shivam424.sj@gmail.com"));
            cart.checkout(100.0);

            cart.setShoppingCart(new CreditCardPayment("1234-5678-8910-1112"));
            cart.checkout(90.0);

            cart.setShoppingCart(new UPIPayment("6191818487@ybl"));
            cart.checkout(80.0);

            System.out.println("Strategy Design Pattern");
    }

}