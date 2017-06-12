package com.mercado.libre.util;

/**
 *
 */
public class CalculoTrigonometrico {

    public static Boolean estanAlineados(Double x1 , Double y1 , Double x2 , Double y2, Double x3 , Double y3 ){
        Double result = (x2-x1)*(y3-y2);
        Double result1 = (y2-y1)*(x3-x2);
        return result==result1;
    }

    public static Boolean calcularOrientacion(Double x1 , Double y1 , Double x2 , Double y2, Double x3 , Double y3){
        return ( ((x1 - x3) * (y2 - y3) - (y1 - y3) * (x2 - x3)) >= 0 );
    }

    public static Double calcularPerimetro(Double x1 , Double y1 , Double x2 , Double y2, Double x3 , Double y3){
        Double ladoAB = calcularLados(x1, y1, x2, y2);
        Double ladoAC = calcularLados(x1, y1, x3, y3);
        Double ladoBC = calcularLados(x2, y2, x3, y3);
        return ladoAB + ladoAC + ladoBC;
    }

    public static Double calcularLados(Double x1 , Double y1 , Double x2 , Double y2){
        return Math.sqrt( Math.pow( (x2-x1), 2 ) + Math.pow( (y2-y1), 2 ) );
    }

}
