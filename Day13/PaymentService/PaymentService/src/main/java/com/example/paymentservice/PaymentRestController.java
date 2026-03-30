package com.example.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentservice.CartRestConsumer;

@RestController
public class PaymentRestController {
    @Autowired
    private CartRestConsumer consumer;

    @GetMapping("/payment/data")
    public String getPaymentData() {

        return "FROM PAYMENT- SERVICE" + consumer.getCartData();
    }
}