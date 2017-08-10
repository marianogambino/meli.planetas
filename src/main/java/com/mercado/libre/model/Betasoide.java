package com.mercado.libre.model;

import java.math.BigDecimal;

/**
 *
 */
public class Betasoide extends Planeta implements Planetable{


    public Betasoide(){
        this.punto = new Punto(BigDecimal.ZERO, new BigDecimal(2000));
        this.distanciaAlSol = 2000;
        this.posicionAngular = 93;
        this.movimientoAngular = -3; //-3
    }
}
