package org.example.Controller;

import org.example.Entities.Booking;
import org.example.Entities.Show;
import org.example.Entities.User;
import org.example.Service.BookingService;

import java.util.List;
import java.util.UUID;

public class BookingController {
    private final BookingService bookingService;
    public BookingController() {
        this.bookingService = new BookingService();
    }
    public Booking getBooking(UUID bookingId) {
        return bookingService.getBooking(bookingId);
    }
    public Booking createBooking(User user, Show show, List<Integer> seats) {
        return bookingService.book(user,show,seats);
    }
    public List<Booking> getBookingsForUSer(User user) {
        return bookingService.getBookingsForUser(user);
    }
}
