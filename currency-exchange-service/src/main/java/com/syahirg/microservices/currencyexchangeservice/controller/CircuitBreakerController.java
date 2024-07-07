package com.syahirg.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {


    @GetMapping("/sample-api")
    //@Retry(name="sample-api", fallbackMethod = "myResponse" )
    @CircuitBreaker(name="default", fallbackMethod = "myResponse")
    public String sampleApi(){
        log.info("sample api call received");
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
        return entity.getBody();
    }

    @GetMapping("/sample-api2")
    @RateLimiter(name="default")
    public String sampleApi2(){
        log.info("sample api call received");
        return "sample-api2";
    }

    @GetMapping("/sample-api3")
    @Bulkhead(name="default")
    public String sampleApi3(){
        log.info("sample api call received");
        return "sample-api3";
    }

    public String myResponse(Exception exception){
        return "fallback-response";
    }
}
