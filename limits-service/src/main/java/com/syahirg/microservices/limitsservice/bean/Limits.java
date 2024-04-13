package com.syahirg.microservices.limitsservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Limits {
    private int minimum;
    private int maximum;
}
