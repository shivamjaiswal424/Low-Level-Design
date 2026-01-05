package org.example.vehicle;

import java.time.LocalDate;

public class DateInterval {
    private final LocalDate from;
    private final LocalDate to;

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public DateInterval(LocalDate from, LocalDate to) {

        if(to.isBefore(from)){
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        this.to = to;
        this.from = from;

    }
    public boolean overlaps(DateInterval other){
        return !(this.to.isBefore(other.from)|| this.from.isAfter(other.to));
    }

}
