package com.mercado.libre.model;

/**
 *
 */
public class Vulcano extends Planeta implements Planetable {



    public Vulcano(){
        this.punto = new Punto(0D,10D);
        this.distanciaAlSol = 10;
        this.posicionAngular = 90;
        this.movimientoAngular = 5;
    }

}
