package com.mercado.libre.model;

import com.mercado.libre.enums.EstadoClimaEnum;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name="DAY")
public class Day implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NUM_DAY")
    private Integer numDay;

    @Column(name = "WEATHER_CONDITION")
    @Enumerated(EnumType.STRING)
    private EstadoClimaEnum weatherCondition;

    public Day(){}

    public Day(Integer numDay , EstadoClimaEnum estado){
        this.numDay = numDay;
        this.weatherCondition = estado;
    }

    public Integer getNumDay() {
        return numDay;
    }

    public void setNumDay(Integer numDay) {
        this.numDay = numDay;
    }

    public EstadoClimaEnum getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(EstadoClimaEnum weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
