package org.example.ParkingLot;

import org.example.Entity.Ticket;
import org.example.Payment.Payment;
import org.example.Pricing.CostComputation;

public class ExitGate {
    private CostComputation costComputation;
    public ExitGate(CostComputation costComputation) {
        this.costComputation = costComputation;
    }
    public  void completeExit(ParkingBuilding parkingBuilding, Ticket ticket, Payment payment) {
        double amount=calculatePrice(ticket);
        boolean success=payment.pay(amount);
        if(!success){
            throw new RuntimeException("Payment failed");

        }
        parkingBuilding.release(ticket);
        System.out.println("Exit successful. Gate opened.");
    }
    private double calculatePrice(Ticket ticket){
        return costComputation.calculate(ticket);
    }
}
