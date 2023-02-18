package com.etraveli.service;

import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class WeatheService {

    private Logger logger = Logger.getLogger(WeatheService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @SneakyThrows
    public Integer sendGet(String url) {
        Integer temp = 0;
        try {
            temp = restTemplate.getForObject(url, Integer.class);
        } catch (Exception e) {
            temp = 999;
            logger.error("Exception : "+ e.getMessage());
        }
        return CompletableFuture.completedFuture(temp).get();
    }

}
