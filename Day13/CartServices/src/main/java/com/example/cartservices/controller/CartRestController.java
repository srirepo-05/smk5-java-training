package com.example.cartservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRestController {

    @GetMapping("/cart/getData")
    public String getData() {
        return "Cart Service is up and running!";
    }
}
