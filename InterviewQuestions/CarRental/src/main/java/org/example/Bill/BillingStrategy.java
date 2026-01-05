package org.example.Bill;

import org.example.reservation.Reservation;

public interface BillingStrategy {
    Bill generateBill(Reservation reservation);
}
