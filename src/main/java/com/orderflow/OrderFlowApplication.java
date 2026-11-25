package com.orderflow;

import com.orderflow.checkout.CheckoutService;
import com.orderflow.payment.PaymentMethod;
import com.orderflow.payment.PaymentRegistry;
import com.orderflow.payment.PaymentService;
import com.orderflow.payment.strategy.CardPayment;
import com.orderflow.payment.strategy.NetBankingPayment;
import com.orderflow.payment.strategy.UpiPayment;

import java.util.Objects;


public class OrderFlowApplication {


    public static void main(String[] args) {

        PaymentRegistry paymentRegistry = new PaymentRegistry();

        paymentRegistry.register(new UpiPayment());
        paymentRegistry.register(new CardPayment());
        paymentRegistry.register(new NetBankingPayment());

        CheckoutService checkoutService =  new CheckoutService(paymentRegistry);

        checkoutService.checkout(PaymentMethod.UPI, 1500);
        checkoutService.checkout(PaymentMethod.CARD,2500);
        checkoutService.checkout(PaymentMethod.NET_BANKING,5000);

    }

}
