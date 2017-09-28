package com.mercado.libre.service;

import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Day;
import org.springframework.stereotype.Service;

/**
 * Created by mariano on 24/09/17.
 */
@Service
public interface WeatherService {

    Day getDay(int day);
    Boolean saveDay(int day, EstadoClimaEnum state);
}
