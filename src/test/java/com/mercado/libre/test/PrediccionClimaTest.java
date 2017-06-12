package com.mercado.libre.test;

import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Betasoide;
import com.mercado.libre.model.Ferengi;
import com.mercado.libre.model.Planetable;
import com.mercado.libre.model.Vulcano;
import com.mercado.libre.util.CalculoTrigonometrico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class PrediccionClimaTest {

    private Planetable ferengi = new Ferengi();
    private Planetable betasoide = new Betasoide( );
    private Planetable vulcano = new Vulcano();

    //Crear Sol

    private Map<Integer, EstadoClimaEnum> diasEstados = new HashMap<Integer, EstadoClimaEnum>();

    private Map<EstadoClimaEnum, List<List<Integer>>> periodos = new HashMap<EstadoClimaEnum, List<List<Integer>>>();

    private Double perimetroMax = 0D;
    private Integer diaMaxLluvia = 0;


    /**
     * Se calculan los dias, son 10 anios por 360 grados dividio los 5 grados de giro por dia del planeta Vulcano
     */
    private Integer dias = 10 * (360/5);

    @Before
    public void setUp(){

    }

    @Test
    public void prediccionClima(){

        //Verificar si estan alineandos
        //si estan alineados, verificar si lo estan con respecto al sol punto (0;0)

        // Si no estan alineados, es un triangulo
        //verificar si el sol se encuentra dentro de la misma, si es asi, calcular el perimetro y calcular el maximo

        for(int i=1; i<=dias; i++){

            ferengi.desplazate();
            betasoide.desplazate();
            vulcano.desplazate();

            Boolean estaAlineados = CalculoTrigonometrico.estanAlineados(
                    ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                    vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                    betasoide.getPunto().getX(), betasoide.getPunto().getY() );

            if(estaAlineados){ // forman una recta

                Boolean estaAlineadosConSol = CalculoTrigonometrico.estanAlineados(
                                                                0D, 0D,
                                                                 ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                                                                 vulcano.getPunto().getX(),vulcano.getPunto().getY() );

                if(estaAlineadosConSol){
                    diasEstados.put(i, EstadoClimaEnum.SEQUIA);
                }else{
                    diasEstados.put(i, EstadoClimaEnum.CONDICIONES_NORMALES);
                }

            }else{ //es un triangulo

                Boolean orientacionInicial =
                        CalculoTrigonometrico.calcularOrientacion(ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                                vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                                betasoide.getPunto().getX(), betasoide.getPunto().getY());

                Boolean orientacionA1A2P =
                        CalculoTrigonometrico.calcularOrientacion(ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                                vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                                0D,0D);

                Boolean orientacionA2A3P =
                        CalculoTrigonometrico.calcularOrientacion(vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                                betasoide.getPunto().getX(), betasoide.getPunto().getY(), 0D, 0D);

                Boolean orientacionA3A1P =
                        CalculoTrigonometrico.calcularOrientacion(ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                                betasoide.getPunto().getX(), betasoide.getPunto().getY(), 0D,0D);

                if(orientacionInicial == orientacionA1A2P ==  orientacionA2A3P == orientacionA3A1P){
                    diasEstados.put(i, EstadoClimaEnum.LLUVIA);

                    Double perimetro = CalculoTrigonometrico.calcularPerimetro(ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                            vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                            betasoide.getPunto().getX(), betasoide.getPunto().getY());
                    if(perimetro > perimetroMax){
                        perimetroMax = perimetro;
                        diaMaxLluvia = i;
                    }


                }else{
                    diasEstados.put(i, EstadoClimaEnum.NUBLADO);
                }

            }

        }

        Assert.assertEquals(diasEstados.get(566).estado(), EstadoClimaEnum.LLUVIA.estado());
        Assert.assertTrue(diaMaxLluvia == 611);

    }
}
