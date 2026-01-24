package org.example.Pricing;

import org.example.Entity.Ticket;

public class CostComputation {
    private final PricingStrategy pricingStrategy;
    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
    public double calculate(Ticket ticket) {
        return pricingStrategy.calculate(ticket);
    }


}
