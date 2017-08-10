package com.mercado.libre.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 */
public class CalculoTrigonometrico {

    public static Boolean estanAlineados(BigDecimal x1 , BigDecimal y1 , BigDecimal x2 , BigDecimal y2, BigDecimal x3 , BigDecimal y3 ) {
        BigDecimal calculo1 = x2.subtract(x1).multiply((y3.subtract(y1)));
        BigDecimal calculo2 = x3.subtract(x1).multiply((y2.subtract(y1)));
        return calculo1.compareTo(calculo2) == 0;
    }

    public static Boolean calcularOrientacion(BigDecimal x1 , BigDecimal y1 , BigDecimal x2 , BigDecimal y2, BigDecimal x3 , BigDecimal y3){
        BigDecimal calculo1 = x1.subtract(x3).multiply( ( y2.subtract(y3)) );
        BigDecimal calculo2 = y1.subtract(y3).multiply( ( x2.subtract(x3)) );
        BigDecimal result = calculo1.subtract(calculo2);
        return ( result.compareTo(BigDecimal.ZERO) > 0 || result.compareTo(BigDecimal.ZERO) == 0 ) ;
    }

    public static BigDecimal calcularPerimetro(BigDecimal x1 , BigDecimal y1 , BigDecimal x2 , BigDecimal y2, BigDecimal x3 , BigDecimal y3){
        BigDecimal ladoAB = calcularLados(x1, y1, x2, y2);
        BigDecimal ladoAC = calcularLados(x1, y1, x3, y3);
        BigDecimal ladoBC = calcularLados(x2, y2, x3, y3);
        return ladoAB.add(ladoAC).add(ladoBC);
    }

    public static BigDecimal calcularLados(BigDecimal x1 , BigDecimal y1 , BigDecimal x2 , BigDecimal y2){
        return new BigDecimal(Math.sqrt( Math.pow( (x2.doubleValue()-x1.doubleValue()), 2 ) + Math.pow( (y2.doubleValue()-y1.doubleValue()), 2 ) ));
    }

}
