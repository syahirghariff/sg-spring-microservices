package com.syahirg.microservices.limitsservice.controller;

import com.syahirg.microservices.limitsservice.bean.Limits;
import com.syahirg.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    private final Configuration configuration;
    public LimitsController(Configuration configuration){
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits(){

        return new Limits(configuration.getMinimum(),
                configuration.getMaximum());
    }
}
