package com.etraveli.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatheService weatheService = new WeatheService();

    @Test
    public void sendGetTest() {
        Mockito.when(restTemplate.getForObject("http://localhost:8080/temperature-info-service/v1/temperature/pune", Integer.class))
          .thenReturn(2);

        Integer temp = weatheService.sendGet("pune");
        Assertions.assertNotNull(temp);
    }
}
