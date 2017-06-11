package com.mercado.libre.model;

/**
 *
 */
public class Ferengi extends Planeta  {


    public Ferengi(){
        this.punto = new Punto(0D,5D);
        this.distanciaAlSol = 5;
        this.posicionAngular = 90;
        this.movimientoAngular = -1;
    }

}
