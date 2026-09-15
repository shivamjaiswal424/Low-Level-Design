package com.example.UberLLD.Service;

import com.example.UberLLD.Model.Payment;
import com.example.UberLLD.Model.PaymentStatus;
import com.example.UberLLD.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(String tripId, double amount, String idempotencyKey ) {

        /*
         * Idempotency check
         */
        Payment existingPayment = paymentRepository.findByIdempotencyKey(idempotencyKey);

        if (existingPayment != null) {
            return existingPayment;
        }

        Payment payment = new Payment(
                UUID.randomUUID().toString(),
                tripId,
                idempotencyKey,
                amount
        );

        /*
         * Simulating external payment call.
         *
         * In a real system this would call
         * Stripe/Razorpay/etc.
         */
        boolean paymentSuccessful = processWithRetry();

        if (paymentSuccessful) {

            payment.setStatus(PaymentStatus.SUCCESS);

        } else {

            payment.setStatus(PaymentStatus.FAILED);
        }

        return paymentRepository.save(payment);
    }

    private boolean processWithRetry() {

        int maxAttempts = 3;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            try {

                /*
                 * Simulate payment provider call.
                 */
                return true;

            } catch (RuntimeException exception) {

                if (attempt == maxAttempts) {
                    return false;
                }

                try {

                    long backoff = (long) Math.pow(2, attempt) * 100;
                    Thread.sleep(backoff);

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();
                    return false;
                }
            }
        }

        return false;
    }
}
