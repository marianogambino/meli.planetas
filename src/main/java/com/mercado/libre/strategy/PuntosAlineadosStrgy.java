package com.mercado.libre.strategy;

import com.mercado.libre.Resolution.Result;
import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Planetable;
import com.mercado.libre.util.CalculoTrigonometrico;

import java.math.BigDecimal;

/**
 *
 */
public class PuntosAlineadosStrgy implements Strategy{

    private Strategy strategy;

    public PuntosAlineadosStrgy(){
        this.strategy = new CalculoTrianguloStrgy();
    }

    @Override
    public Result execute(Planetable p1, Planetable p2, Planetable p3) {

        Result result = new Result();
        Boolean estaAlineados = CalculoTrigonometrico.estanAlineados(
                p1.getPunto().getX(), p1.getPunto().getY(),
                p2.getPunto().getX(),p2.getPunto().getY(),
                p3.getPunto().getX(), p3.getPunto().getY() );

        if(estaAlineados) { // forman una recta

            Boolean estaAlineadosConSol = CalculoTrigonometrico.estanAlineados(
                    BigDecimal.ZERO, BigDecimal.ZERO,
                    p1.getPunto().getX(), p1.getPunto().getY(),
                    p2.getPunto().getX(), p2.getPunto().getY());

            if (estaAlineadosConSol) {
                result.setEstado(EstadoClimaEnum.SEQUIA);
            }
            return result;

        }
        return strategy.execute(p1, p2, p3);
    }
}
