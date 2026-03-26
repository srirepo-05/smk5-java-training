package com.example.springsecurity;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated  // enables method-level constraint validation
public class HomeController {

    // "/" is open to everyone — no login required
    @GetMapping("/")
    public String home() {
        return "Welcome to the Home Page!";
    }

    // "/admin" is protected by Spring Security (ADMIN role required)
    @GetMapping("/admin")
    public String admin() {
        return "Welcome to the Admin Page!";
    }

    // "/user" is protected by Spring Security (USER role required)
    @GetMapping("/user")
    public String user() {
        return "Welcome to the User Page!";
    }



    // Handles constraint violations thrown by @Validated on this controller
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(
            ConstraintViolationException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(cv -> {
            // extract just the parameter name from the full path
            String field = cv.getPropertyPath().toString();
            field = field.contains(".") ? field.substring(field.lastIndexOf('.') + 1) : field;
            errors.put(field, cv.getMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}

