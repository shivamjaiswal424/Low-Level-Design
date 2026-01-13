package org.example.Entities;

import org.example.Enums.PaymentStatus;

import java.util.List;
import java.util.UUID;

public class Booking {
    private final UUID bookingId;
    private final User user;
    private final Show show;
    private final List<Integer> seats;
    private final Payment payemnt;

    public Booking(User user, Show show, List<Integer> seats, Payment payemnt) {
        this.bookingId = UUID.randomUUID();
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.payemnt = payemnt;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Payment getPayemnt() {
        return payemnt;
    }
}
