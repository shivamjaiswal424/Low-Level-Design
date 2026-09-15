package com.example.UberLLD.Repository;

import com.example.UberLLD.Model.Payment;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PaymentRepository {

    private final Map<String, Payment> payments = new ConcurrentHashMap<>();

    private final Map<String, Payment> idempotencyIndex = new ConcurrentHashMap<>();

    public Payment save(Payment payment) {

        payments.put(payment.getId(), payment);

        idempotencyIndex.put(payment.getIdempotencyKey(), payment);

        return payment;
    }

    public Payment findByIdempotencyKey(String key) {

        return idempotencyIndex.get(key);
    }
}