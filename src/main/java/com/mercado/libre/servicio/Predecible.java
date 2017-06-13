package com.mercado.libre.servicio;

import com.mercado.libre.enums.EstadoClimaEnum;

import java.util.Map;

/**
 *
 */
public interface Predecible {
    void predecir(Integer anios, Integer velocidadAngular);
    Map<Integer,EstadoClimaEnum> getDiasEstado();
    Integer getDiaMaxLluvia();
    Integer getCantPeriodosSequia();
    Integer getCantPeriodosLluvia();
    Integer getCantPeriodosCOPT();
}
