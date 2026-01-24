package org.example.Payment;

public class Cash implements Payment {
    @Override
    public boolean pay(double amount) {
        System.out.println("Cash paid: " + amount);
        return true;

    }
}
