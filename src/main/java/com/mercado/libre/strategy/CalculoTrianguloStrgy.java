package com.mercado.libre.strategy;

import com.mercado.libre.Resolution.Result;
import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Planetable;
import com.mercado.libre.model.Punto;
import com.mercado.libre.util.CalculoTrigonometrico;

/**
 *
 */
public class CalculoTrianguloStrgy implements Strategy{

    private final static Punto SOL = new Punto(0D, 0D);
    private Double perimetroMax = 0D;

    @Override
    public Result execute(Planetable p1, Planetable p2, Planetable p3) {

        Result result = new Result();
        Boolean orientacionInicial = calcularOrientacionInicial(p1,p2,p3);
        Boolean orientacionA1A2P = calcularOrientacionA1A2P(p1,p2);
        Boolean orientacionA2A3P = calcularOrientacionA2A3P(p2, p3);
        Boolean orientacionA3A1P = calcularOrientacionA3A1P(p1, p3);

        result.setEstado(EstadoClimaEnum.NUBLADO);
        if(orientacionInicial == orientacionA1A2P ==  orientacionA2A3P == orientacionA3A1P){

            Double perimetro = CalculoTrigonometrico.calcularPerimetro(p1.getPunto().getX(), p1.getPunto().getY(),
                    p2.getPunto().getX(),p2.getPunto().getY(),
                    p3.getPunto().getX(), p3.getPunto().getY());
            result.setPerimetro(perimetro);
            result.setEstado(EstadoClimaEnum.LLUVIA);
        }
        return result;
    }


    private Boolean calcularOrientacionInicial(Planetable p1, Planetable p2, Planetable p3){
        return CalculoTrigonometrico.calcularOrientacion(
                p1.getPunto().getX(), p1.getPunto().getY(),
                p2.getPunto().getX(),p2.getPunto().getY(),
                p3.getPunto().getX(), p3.getPunto().getY());
    }

    private Boolean calcularOrientacionA1A2P(Planetable p2, Planetable p3){
        return CalculoTrigonometrico.calcularOrientacion(
                p2.getPunto().getX(),p2.getPunto().getY(),
                p3.getPunto().getX(), p3.getPunto().getY(), SOL.getX(), SOL.getY());
    }

    private Boolean calcularOrientacionA2A3P(Planetable p1, Planetable p2){
        return  CalculoTrigonometrico.calcularOrientacion(
                p1.getPunto().getX(), p1.getPunto().getY(),
                p2.getPunto().getX(),p2.getPunto().getY(),
                SOL.getX(), SOL.getY());
    }

    private Boolean calcularOrientacionA3A1P(Planetable p1, Planetable p3){
       return CalculoTrigonometrico.calcularOrientacion(
                p1.getPunto().getX(), p1.getPunto().getY(),
                p3.getPunto().getX(), p3.getPunto().getY(), SOL.getX(), SOL.getY());
    }
}
