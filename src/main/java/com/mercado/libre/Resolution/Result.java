package com.mercado.libre.Resolution;

import com.mercado.libre.enums.EstadoClimaEnum;

/**
 *
 */
public class Result {

    private EstadoClimaEnum estado = EstadoClimaEnum.CONDICIONES_NORMALES;
    private Double perimetro = 0D;

    public EstadoClimaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoClimaEnum estado) {
        this.estado = estado;
    }

    public Double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(Double perimetro) {
        this.perimetro = perimetro;
    }
}
