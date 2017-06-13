package com.mercado.libre.strategy;

import com.mercado.libre.Resolution.Result;
import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Planetable;

/**
 *
 */
public interface Strategy {
    Result execute(Planetable p1, Planetable p2, Planetable p3);
}
