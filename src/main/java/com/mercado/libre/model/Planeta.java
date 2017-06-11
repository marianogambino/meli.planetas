package com.mercado.libre.model;

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
        Double x = this.distanciaAlSol * Math.cos(Math.toRadians(this.posicionAngular));
        Double y = this.distanciaAlSol * Math.sin(Math.toRadians(this.posicionAngular));
        this.punto = new Punto(x, y );
    }

    private void calcularPosicionAngular(){
        Integer posAngular = this.posicionAngular + this.movimientoAngular;
        if( posAngular < 0 ){
            posAngular = GRADO_360 = posAngular;
        } else  if (posAngular > GRADO_360){
            posAngular = posAngular - GRADO_360;
        }
        this.posicionAngular = posAngular;
    }


}
