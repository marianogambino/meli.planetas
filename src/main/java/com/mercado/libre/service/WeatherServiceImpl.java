package com.mercado.libre.service;

import com.mercado.libre.dao.DayDao;
import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mariano on 24/09/17.
 */
@Service
@Transactional
public class WeatherServiceImpl implements WeatherService {

    private final DayDao dao;

    @Autowired
    public WeatherServiceImpl(@Qualifier("dayDaoImpl") DayDao dao) {
        this.dao = dao;
    }

    @Override
    public Day getDay(int day) {
        return dao.getDay(day);
    }

    @Override
    public Boolean saveDay(int day, EstadoClimaEnum state) {
        return dao.save(new Day(day, state));
    }
}
