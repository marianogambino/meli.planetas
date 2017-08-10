package com.mercado.libre.model;

import java.math.BigDecimal;

/**
 *
 */
public class Vulcano extends Planeta implements Planetable {



    public Vulcano(){
        this.punto = new Punto(BigDecimal.ZERO, new BigDecimal(1000));
        this.distanciaAlSol = 1000;
        this.posicionAngular = 85;
        this.movimientoAngular = 5; //5
    }

}
