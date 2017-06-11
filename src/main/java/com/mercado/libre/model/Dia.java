package com.mercado.libre.model;

import com.mercado.libre.enums.EstadoClimaEnum;

/**
 *
 */
public class Dia {

    private Integer nro;
    private EstadoClimaEnum estadoClima;

    public Dia(){}

    public Dia(Integer nro , EstadoClimaEnum estado){
        this.nro = nro;
        this.estadoClima = estado;
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public EstadoClimaEnum getEstadoClima() {
        return estadoClima;
    }

    public void setEstadoClima(EstadoClimaEnum estadoClima) {
        this.estadoClima = estadoClima;
    }
}
