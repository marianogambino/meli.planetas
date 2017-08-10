package com.mercado.libre.restservice;

import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Dia;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mariano on 03/07/17.
 */
@RestController
@RequestMapping("vulcano/{dia}")
public class PlanetRestController {

    PlanetRestController(){
    }

    @RequestMapping(method = RequestMethod.GET)
    Dia readWeather(@PathVariable int dia){
        return new Dia(1, EstadoClimaEnum.CONDICIONES_NORMALES);
    }


}
