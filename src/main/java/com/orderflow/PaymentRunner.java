package com.orderflow;

import com.orderflow.checkout.CheckoutService;
import com.orderflow.payment.PaymentMethod;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PaymentRunner implements CommandLineRunner {

    private  final CheckoutService checkoutService;
    public  PaymentRunner(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }
    @Override
    public void run(String... args) throws Exception{
        checkoutService.checkout(PaymentMethod.UPI, 1500);
        checkoutService.checkout(PaymentMethod.CARD, 2500);
        checkoutService.checkout(PaymentMethod.NET_BANKING, 5000);
    }
}
