package com.mercado.libre.Resolution;

import com.mercado.libre.enums.EstadoClimaEnum;

import java.math.BigDecimal;

/**
 *
 */
public class Result {

    private EstadoClimaEnum estado = EstadoClimaEnum.CONDICIONES_NORMALES;
    private BigDecimal perimetro = BigDecimal.ZERO;

    public EstadoClimaEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoClimaEnum estado) {
        this.estado = estado;
    }

    public BigDecimal getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(BigDecimal perimetro) {
        this.perimetro = perimetro;
    }
}
