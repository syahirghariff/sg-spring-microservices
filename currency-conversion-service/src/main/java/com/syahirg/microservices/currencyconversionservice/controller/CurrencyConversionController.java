package com.syahirg.microservices.currencyconversionservice.controller;

import com.syahirg.microservices.currencyconversionservice.model.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculate(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity){

        return new CurrencyConversion(1000L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "");
    }

}
