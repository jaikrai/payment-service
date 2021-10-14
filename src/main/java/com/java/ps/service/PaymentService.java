package com.java.ps.service;

import com.java.ps.entity.Payment;
import com.java.ps.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());

        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }
    public String paymentProcessing(){
        // api shpuld be 3rd party payment gateway (payple
        return new Random().nextBoolean() ? "success" : "false";
    }

    public Payment findPaymentHistoryByOrderId(int orderId) {
       return repository.findByOrderId(orderId);
    }
}