package org.example.Payment;

public class UPI implements Payment {

    @Override
    public boolean pay(double amount) {
        System.out.println("UPI paid: " + amount);
        return true;

    }
}
