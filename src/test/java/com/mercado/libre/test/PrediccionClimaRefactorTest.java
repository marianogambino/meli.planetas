package com.mercado.libre.test;

import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.servicio.PrediccionClima;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class PrediccionClimaRefactorTest {

    private PrediccionClima prediccionClima;

    @Before
    public void setUp(){
        prediccionClima = new PrediccionClima();
    }

    @Test
    public void prediccionClima(){
        prediccionClima.predecir(10, 5);

        Assert.assertEquals(prediccionClima.getDiasEstado().get(566).estado(), EstadoClimaEnum.LLUVIA.estado());
        Assert.assertTrue(prediccionClima.getDiaMaxLluvia() == 611);
    }

}
