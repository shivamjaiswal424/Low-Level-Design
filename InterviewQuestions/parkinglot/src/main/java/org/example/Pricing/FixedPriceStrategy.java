package org.example.Pricing;

import org.example.Entity.Ticket;

public class FixedPriceStrategy implements PricingStrategy {
    @Override
    public double calculate(Ticket ticket) {
        return 100.0;
    }
}
