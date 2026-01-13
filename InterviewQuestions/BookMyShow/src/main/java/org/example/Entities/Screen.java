package org.example.Entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {
    private final int screenId;
    private final List<Seat> seats;
    private final Map<LocalDate,List<Show>> showsByDate=new HashMap<>();

    public Screen(int screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
    }
    public List<Seat> getSeats() {
        return seats;
    }
    public void addShow(Show show) {

    }
    public List<Show> getShowsByDate(LocalDate date) {
        return showsByDate.getOrDefault(date,List.of());
    }
}
