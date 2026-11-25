package com.orderflow.payment.strategy;

import com.orderflow.payment.PaymentMethod;
import com.orderflow.payment.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class UpiPayment implements PaymentService {

    @Override
    public void pay(double amount){
        System.out.println("UPI payment is processing.." + amount);
    }
    @Override
    public PaymentMethod getPaymentMethod(){
        return PaymentMethod.UPI;
    }

}
