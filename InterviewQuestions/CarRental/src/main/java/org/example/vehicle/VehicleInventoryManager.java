package org.example.vehicle;

import org.example.reservation.Reservation;
import org.example.reservation.ReservationRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class VehicleInventoryManager {
    // vehicleId → Vehicle
    private final ConcurrentMap<Integer,Vehicle> vehicles=new ConcurrentHashMap<>();
    // vehicleId → list of reservation IDs (metadata index)
    private final ConcurrentMap<Integer, List<Integer>>vehicleBookingsIds=new ConcurrentHashMap<>();
    //per-vehicle lock

    private final ConcurrentMap<Integer, ReentrantLock> vehicleLocks=new ConcurrentHashMap<>();


    private ReservationRepository reservationRepository;

    public ReservationRepository getReservationRepository() {
        return reservationRepository;
    }

    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getVehicleId(), vehicle);
    }
    public Optional<Vehicle> getVehicle(int vehicleId){
        return Optional.ofNullable(vehicles.get(vehicleId));
    }
    private ReentrantLock lockForVehicle(int vehicleId){
        vehicleLocks.putIfAbsent(vehicleId,new ReentrantLock());
        return vehicleLocks.get(vehicleId);
    }
    //-----------------------Availability Check----------------------------
    public boolean isAvailable(int vehicleId, LocalDate from, LocalDate to){
        Vehicle vehicle=vehicles.get(vehicleId);
        if(vehicle==null) return false;
        if(vehicle.getVehicleStatus()==VehicleStatus.MAINTENANCE) return false;

        DateInterval requested=new DateInterval(from,to);
        List<Integer> reservationIds=vehicleBookingsIds.get(vehicleId);
        if(reservationIds==null || reservationIds.isEmpty()){
            return true;
        }
        for(int reservationId:reservationIds){
            Reservation reservation=reservationRepository.findById(reservationId).get();
            LocalDate bookedFrom=reservation.getDateBookedFrom();
            LocalDate bookedTill=reservation.getDateBookedTo();
            DateInterval bookedInterval=new DateInterval(bookedFrom,bookedTill);
            if(bookedInterval.overlaps(requested)) return false;
        }
        return true;
    }
    public boolean reserve(int vehicleId,int reservationId,LocalDate from,LocalDate to){
        ReentrantLock lock=lockForVehicle(vehicleId);
        lock.lock();
        try{
            if(!isAvailable(vehicleId,from,to)){
                return false;
            }
            vehicleBookingsIds.putIfAbsent(vehicleId,new ArrayList<>());
            vehicleBookingsIds.get(vehicleId).add(reservationId);
            vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.BOOKED);
            return true;
        }
        finally {
            lock.unlock();
        }

    }
    public void release(int vehicleId,int reservationId){
        ReentrantLock lock=lockForVehicle(vehicleId);
        lock.lock();
        try{
            List<Integer>ids=vehicleBookingsIds.get(vehicleId);
            if(ids!=null){
                ids.remove(Integer.valueOf(reservationId));
            }
            List<Integer> stillBooked=vehicleBookingsIds.get(vehicleId);
            if(stillBooked==null || stillBooked.isEmpty()){
                vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.AVAILABLE);
            }
        }
        finally {
            lock.unlock();
        }
    }
    public List<Vehicle> getAvailableVehicles(VehicleType type,LocalDate from,LocalDate to){
        return vehicles.values().stream().filter(v->v.getVehicleType()==type)
                .filter(v->isAvailable(v.getVehicleId(),from,to))
                .collect(Collectors.toList());
    }
}
