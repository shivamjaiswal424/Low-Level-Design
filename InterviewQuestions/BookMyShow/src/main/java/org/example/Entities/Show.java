package org.example.Entities;

import org.example.Enums.SeatStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Show {
    private final Movie movie;
    private final LocalDate showDate;
    private final LocalTime startTime;

    private final Map<Integer, SeatStatus> setStatusMap=new HashMap<>();
    private final Map<Integer, ReentrantLock> setLocks=new HashMap<>();

    public Show(Movie movie,Screen screen, LocalDate showDate, LocalTime startTime) {
        this.movie = movie;
        this.showDate = showDate;
        this.startTime = startTime;

       for(Seat seat: screen.getSeats()){
           setStatusMap.put(seat.getSeatId(),SeatStatus.AVAILABLE);
           setLocks.put(seat.getSeatId(),new ReentrantLock());
       }
    }
    public Movie getMovie() {
        return movie;
    }
    public LocalDate getShowDate() {
        return showDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public boolean lockSeats(List<Integer> seatIds){
        List<Integer> sorted =new ArrayList<>(seatIds);
        Collections.sort(sorted);
        List<ReentrantLock> acquiredLocks=new ArrayList<>();
        try{
            //1.acquire all locks
            for(int seatId:sorted){
                ReentrantLock lock=setLocks.get(seatId);
                lock.lock();
                acquiredLocks.add(lock);
            }
            //2.validate availability
            for (int seatId: sorted){
                if (!setStatusMap.get(seatId).equals(SeatStatus.AVAILABLE)){
                    return false;
                }
            }
            //3.mark LOCKED
            for (int seatId: sorted){
                setStatusMap.put(seatId,SeatStatus.AVAILABLE);
            }
            return true;
        }
        finally {
            for(ReentrantLock lock:acquiredLocks){
                lock.unlock();
            }
        }
    }
    public void confirmSeats(List<Integer> seatIds){
        for (int seatId: seatIds){
            setStatusMap.put(seatId,SeatStatus.AVAILABLE);
        }
    }
    public void releaseSeats(List<Integer> seatIds){
        for (int seatId: seatIds){
            setStatusMap.put(seatId,SeatStatus.AVAILABLE);
        }
    }
}
