package com.mercado.libre.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Clase Planeta
 */
public class Planeta implements Planetable {

    private static Integer GRADO_360 = 360;

    protected Punto punto; //coordenadas (x;y)
    protected Integer distanciaAlSol; //radio
    protected Integer posicionAngular; //angulo formado con respecto al eje x
    protected Integer movimientoAngular;


    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public Integer getDistanciaAlSol() {
        return distanciaAlSol;
    }

    public void setDistanciaAlSol(Integer distanciaAlSol) {
        this.distanciaAlSol = distanciaAlSol;
    }

    public Integer getPosicionAngular() {
        return posicionAngular;
    }

    public void setPosicionAngular(Integer posicionAngular) {
        this.posicionAngular = posicionAngular;
    }

    public Integer getMovimientoAngular() {
        return movimientoAngular;
    }

    public void setMovimientoAngular(Integer movimientoAngular) {
        this.movimientoAngular = movimientoAngular;
    }

    /**
     *
     */
    public void desplazate() {
        calcularPosicionAngular();
        BigDecimal cos = new BigDecimal(Math.cos(Math.toRadians(this.posicionAngular)));
        BigDecimal sin = new BigDecimal( Math.sin(Math.toRadians(this.posicionAngular)) );
        BigDecimal x = cos.multiply(new BigDecimal(this.distanciaAlSol));
        BigDecimal y = sin.multiply( new BigDecimal(this.distanciaAlSol )) ;
        this.punto = new Punto(x.setScale(2, RoundingMode.HALF_DOWN), y.setScale(2, RoundingMode.HALF_DOWN) );
    }

    private void calcularPosicionAngular(){
        Integer posAngular = this.posicionAngular + this.movimientoAngular;
        if( posAngular < 0 ){
            posAngular = GRADO_360 - posAngular;
        } else  if (posAngular.compareTo(GRADO_360) > 0){
            posAngular = posAngular - GRADO_360;
        }
        this.posicionAngular = posAngular;
    }




}
