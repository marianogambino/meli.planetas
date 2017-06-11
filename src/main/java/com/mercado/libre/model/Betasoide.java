package com.mercado.libre.model;

/**
 *
 */
public class Betasoide extends Planeta implements Planetable{


    public Betasoide(){
        this.punto = new Punto(0D,20D);
        this.distanciaAlSol = 20;
        this.posicionAngular = 90;
        this.movimientoAngular = -3;
    }
}
