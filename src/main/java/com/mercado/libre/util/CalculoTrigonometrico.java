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


}
