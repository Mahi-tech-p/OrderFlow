package com.orderflow.payment.strategy;

import com.orderflow.payment.PaymentMethod;
import com.orderflow.payment.PaymentService;

public class NetBankingPayment implements PaymentService {
    @Override
    public void pay(double amount){
        System.out.println("Net Banking payment is processing.. " + amount);
    }

    @Override
    public PaymentMethod getPaymentMethod(){
        return PaymentMethod.NET_BANKING ;
    }
}
