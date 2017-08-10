package com.mercado.libre.model;

import java.math.BigDecimal;

/**
 *
 */
public class Ferengi extends Planeta  {


    public Ferengi(){
        this.punto = new Punto(BigDecimal.ZERO, new BigDecimal(500));
        this.distanciaAlSol = 500;
        this.posicionAngular = 91;
        this.movimientoAngular = -1;
    }

}
