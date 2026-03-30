package com.example.itdept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ITController {

    @Autowired
    private HrConsumer hrConsumer;

    @GetMapping("/allowed")
    public String allowed() {
        return "Do you have leave?: "+ hrConsumer.getLeave();
    }
}