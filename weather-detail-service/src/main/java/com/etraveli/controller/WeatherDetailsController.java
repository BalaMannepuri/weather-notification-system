package com.etraveli.controller;

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherDetailsController {

    private Logger logger = Logger.getLogger(WeatherDetailsController.class);

    @GetMapping("/v1/weather/{city}")
    public Integer greet(@PathVariable String city, ModelMap model) {
        int min = -20; // Minimum value of range
        int max = 50; // Maximum value of range
        int temp = (int)Math.floor(Math.random() * (max - min + 1) + min);

        logger.info("Weather Info from /v1/weather/" + city + " Temperature is " + temp);
        return temp;
    }
}