package com.orderflow.payment;

public interface PaymentService {
    void pay(double amount);
    PaymentMethod getPaymentMethod();
}
