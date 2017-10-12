package com.mercado.libre.test;

import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.service.PrediccionClima;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import prc.ar.csv.generator.CVSGralGenerator;

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
        prediccionClima.predecir(150, 1); //

        Assert.assertEquals(prediccionClima.getDiasEstado().get(566).estado(), EstadoClimaEnum.LLUVIA.estado());
//        Assert.assertTrue(prediccionClima.getDiaMaxLluvia() == 612);
//        Assert.assertTrue(prediccionClima.getCantPeriodosCOPT() == 0);
//        Assert.assertTrue(prediccionClima.getCantPeriodosLluvia() == 42);
//        Assert.assertTrue(prediccionClima.getCantPeriodosSequia()== 1);
    }


//    @Test
//    public void generateCSVPredictionTest(){
//        prediccionClima.predecir(10, 5);
//        String fileName = "/home/mariano/Mariano/Dev/java/practice/meli.planetas/src/test/resources/prediction.csv";
//        CVSGralGenerator generator =  new CVSGralGenerator(fileName, ";");
//
//        String[] register;
//        for(Integer day : prediccionClima.getDiasEstado().keySet() ){
//            register = new String[2];
//            register[0] = day.toString();
//            register[1] = prediccionClima.getDiasEstado().get(day).estado().toUpperCase();
//            generator.writeCSV(register);
//        }
//        generator.commit();
//    }


}
