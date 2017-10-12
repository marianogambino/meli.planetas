package com.mercado.libre.integration.test.bd;


import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.restservice.Application;
import com.mercado.libre.service.WeatherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by mariano on 24/09/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = Application.class)
@TestPropertySource(
        locations = "classpath:application.yml")
@ContextConfiguration(classes = Application .class)

public class TestBD {
    @Autowired
    private WeatherService weatherService;


    @Test
    public void testPersist(){
        Boolean result = weatherService.saveDay(2, EstadoClimaEnum.LLUVIA);
        Assert.assertTrue(result);
    }


}
