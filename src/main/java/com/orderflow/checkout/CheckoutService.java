package com.orderflow.checkout;

import com.orderflow.payment.PaymentMethod;
import com.orderflow.payment.PaymentRegistry;
import com.orderflow.payment.PaymentService;

import java.util.Objects;

public class CheckoutService {

    private final PaymentRegistry paymentRegistry;

    public CheckoutService(PaymentRegistry paymentRegistry){
        this.paymentRegistry = Objects.requireNonNull(paymentRegistry);
    }

    public void checkout(PaymentMethod method, double amount){
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                    "Invalid payment amount: " + amount
            );
        }
       PaymentService paymentStrategy = paymentRegistry.getPaymentService(method);
       paymentStrategy.pay(amount);
    }
}
