package com.mercado.libre.model;

import java.math.BigDecimal;

/**
 *
 */
public class Punto {

    private BigDecimal x;
    private BigDecimal y;

    public Punto(BigDecimal x , BigDecimal y ){
        this.x = x;
        this.y = y;
    }

    public Punto(){}

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }
}
