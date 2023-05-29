package com.example.paymentapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {


    @GetMapping("/getcount")


    public Integer getCount()
    {

      return PaymentAppApplication.COUNTER++;
    }
}
