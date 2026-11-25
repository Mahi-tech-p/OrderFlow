package com.orderflow.payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PaymentRegistry {


    private final Map<PaymentMethod, PaymentService> payments =  new HashMap<>();
    public  void register(PaymentService paymentService){

        Objects.requireNonNull(paymentService, "Payment service cannot be null");

        PaymentMethod paymentMethod = Objects.requireNonNull(paymentService.getPaymentMethod(), "Payment Method cannot be null");

        if(payments.containsKey(paymentMethod)){
            throw new IllegalStateException("Payment Method already registered: " + paymentMethod);
        }
        payments.put(paymentMethod , paymentService);
    }
    public PaymentService getPaymentService(PaymentMethod paymentMethod){

        PaymentService paymentService = payments.get(paymentMethod);

        if(paymentService == null){
            throw new IllegalArgumentException("Unsupported Payment Method: "+ paymentMethod);
        }

        return paymentService;
    }
}
