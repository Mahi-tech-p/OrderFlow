package com.orderflow.payment.strategy;

import com.orderflow.payment.PaymentMethod;
import com.orderflow.payment.PaymentService;

public class CardPayment implements PaymentService {

    @Override
    public void pay(double amount){
        System.out.println("Card payment is processing.. " + amount);
    }

    @Override
    public PaymentMethod getPaymentMethod(){
        return PaymentMethod.CARD ;
    }

}
