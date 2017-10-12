package com.mercado.libre.restservice;

import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Day;
import com.mercado.libre.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mariano on 03/07/17.
 */
@RestController
public class PlanetRestController {

    @Qualifier("weatherServiceImpl")
    @Autowired
    private WeatherService service;

    PlanetRestController(){
    }

    @RequestMapping(value = "vulcano/{dia}", method = RequestMethod.GET)
    Day readWeather(@PathVariable int dia){
        return service.getDay(dia);
    }


}
