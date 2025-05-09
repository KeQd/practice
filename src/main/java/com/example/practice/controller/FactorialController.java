package com.example.practice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Factorial")
public class FactorialController {

    @GetMapping()
    public String getFactorial(@RequestParam int n) {
        int value = 1;
        for(int i = 1; i <= n; i++) {
            value *= i;
        }
        return "Silnia z " + n + " to: " +  value;
    }
}
