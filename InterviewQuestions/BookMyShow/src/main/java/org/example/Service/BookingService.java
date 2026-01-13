package org.example.Service;

import org.example.Entities.Booking;
import org.example.Entities.Payment;
import org.example.Entities.Show;
import org.example.Entities.User;
import org.example.Enums.PaymentStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {
    private final Map<UUID, Booking> bookings=new HashMap<>();

    public Booking book(User user, Show show, List<Integer> seats){
        if(!show.lockSeats(seats)){
            throw new RuntimeException("Seat unavailable");
        }
        Payment payment=new Payment(PaymentStatus.SUCCESS);
        if (payment.getPaymentStatus()==PaymentStatus.SUCCESS){
            show.confirmSeats(seats);
            Booking booking=new Booking(user,show,seats,payment);
            bookings.put(booking.getBookingId(),booking);

            return booking;
        }
        else{
            show.releaseSeats(seats);
            throw  new RuntimeException("Seat unavailable");
        }
    }
    public Booking getBooking(UUID id) {
        return bookings.get(id);
    }
    public List<Booking> getBookingsForUser(User user) {
        return bookings.values().stream().filter(b->b.getUser().equals(user)).toList();
    }
}
