package org.example;

import org.example.Bill.Bill;
import org.example.Bill.BillManager;
import org.example.Bill.BillingStrategy;
import org.example.Bill.DailyBillingStrategy;
import org.example.Payment.Payment;
import org.example.Payment.PaymentManager;
import org.example.Payment.PaymentStrategy;
import org.example.Payment.UPIPaymentStrategy;
import org.example.reservation.Reservation;
import org.example.reservation.ReservationManager;
import org.example.reservation.ReservationType;
import org.example.vehicle.Vehicle;
import org.example.vehicle.VehicleInventoryManager;
import org.example.vehicle.VehicleType;

import java.time.LocalDate;
import java.util.List;

public class Store {
    private final int storeId;
    private final Location storeLocation;
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationManager reservationManager;
    private final BillManager billManager;
    private final PaymentManager paymentManager;

    public Store(int storeId, Location storeLocation) {
        this.storeId = storeId;
        this.storeLocation = storeLocation;
        this.vehicleInventoryManager = new VehicleInventoryManager();
        this.reservationManager = new ReservationManager(vehicleInventoryManager);
        this.billManager = new BillManager(new DailyBillingStrategy(vehicleInventoryManager));
        this.paymentManager = new PaymentManager(new UPIPaymentStrategy());
    }
    // ----------------- Search Vehicles --------------------

    public List<Vehicle> getVehicles(VehicleType vehicleType, LocalDate from,LocalDate to){
        return vehicleInventoryManager.getAvailableVehicles(vehicleType,from,to);
    }
    // ----------------- Create Reservation -----------------
    public Reservation createReservation(int vehicleId, User user, LocalDate from, LocalDate to,
                                         ReservationType type) throws Exception {
        return reservationManager.createReservation(vehicleId, user, from, to, type);
    }
    // ----------------- Update Reservation -----------------

    public void cancelReservation(int reservationId) {
        reservationManager.cancelReservation(reservationId);
    }

    public void startTrip(int reservationId) {
        reservationManager.startTrip(reservationId);
    }

    public void submitVehicle(int reservationId) {
        reservationManager.submitVehicle(reservationId);
    }
// ----------------- Billing & Payment ------------------

    public Bill generateBill(int reservationId, BillingStrategy billingStrategy) {
        Reservation r = reservationManager.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        billManager.setBillingStrategy(billingStrategy);
        return billManager.generateBill(r);
    }

    public Payment makePayment(Bill bill, PaymentStrategy paymentStrategy, double paymentAmount) {

        paymentManager.setPaymentStrategy(paymentStrategy);
        Payment payment = paymentManager.makePayment(bill, paymentAmount);

        if (!bill.isBillPaid()) {
            throw new RuntimeException("Payment failed");
        }

        // NOW we can safely remove the reservation from the repo
        reservationManager.remove(bill.getReservationId());
        return payment;
    }


    public VehicleInventoryManager getInventory() {
        return vehicleInventoryManager;
    }

    public int getStoreId() {
        return storeId;
    }


}
