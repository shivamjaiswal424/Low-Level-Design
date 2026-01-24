package org.example.Pricing;

import org.example.Entity.Ticket;

public interface PricingStrategy {
    double calculate(Ticket ticket);

}
