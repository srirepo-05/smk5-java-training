package com.example.hrdept.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HRController {
    @GetMapping("/leavestatus")
    public boolean checkLeaveStatus() {
        boolean isLeaveApproved = true; // Simulate leave approval status
        return isLeaveApproved;
    }
}
