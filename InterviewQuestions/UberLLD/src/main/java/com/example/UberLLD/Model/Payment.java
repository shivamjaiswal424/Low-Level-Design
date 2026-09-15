package com.example.UberLLD.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {

    private final String id;
    private final String tripId;
    private final String idempotencyKey;

    private final double amount;

    private PaymentStatus status;

    public Payment(
            String id,
            String tripId,
            String idempotencyKey,
            double amount
    ) {
        this.id = id;
        this.tripId = tripId;
        this.idempotencyKey = idempotencyKey;
        this.amount = amount;
        this.status = PaymentStatus.CREATED;
    }

    public String getId() {
        return id;
    }

    public String getTripId() {
        return tripId;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

}