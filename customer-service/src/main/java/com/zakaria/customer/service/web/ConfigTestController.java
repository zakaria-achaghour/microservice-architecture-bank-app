package com.zakaria.customer.service.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTestController {

    @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")
    private int p2;

    @Value("${customer.params.x}")
    private int x;
    @Value("${customer.params.y}")
    private int y;

}
