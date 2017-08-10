package com.mercado.libre.test;

import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Betasoide;
import com.mercado.libre.model.Ferengi;
import com.mercado.libre.model.Planetable;
import com.mercado.libre.model.Vulcano;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class TrigonometriaTest {

    private Planetable ferengi = new Ferengi();
    private Planetable betasoide = new Betasoide( );
    private Planetable vulcano = new Vulcano();

    private Map<Integer, EstadoClimaEnum> diasEstados = new HashMap<Integer, EstadoClimaEnum>();

    private Map<EstadoClimaEnum, List<List<Integer>>> periodos = new HashMap<EstadoClimaEnum, List<List<Integer>>>();

    private Integer diaMaxLluvia;

    @Before
    public void setUp(){

    }

    @Test
    public void calculoTrigonometrico(){

        Double x = 1000 * Math.cos(Math.toRadians(90));
        Double y = 1000 * Math.sin(Math.toRadians(90));

        BigDecimal xx = BigDecimal.valueOf(x);
        BigDecimal yy = BigDecimal.valueOf(y);

        BigDecimal xx1 = new BigDecimal(x);
        BigDecimal yy1 = new BigDecimal(y);

        Assert.assertEquals(x.doubleValue(), 6.123233995736766E-14, 0) ;
        Assert.assertEquals(y.doubleValue(), 1000D, 0) ;

        Assert.assertEquals(xx.setScale(2, RoundingMode.DOWN), BigDecimal.valueOf(0.00).setScale(2, RoundingMode.DOWN)) ;
        Assert.assertEquals(yy, BigDecimal.valueOf(1000.0)) ;

    }

    @Test
    public void calcularPuntoInical(){

        int posicioAngular = ferengi.getPosicionAngular();
        ferengi.setPosicionAngular(posicioAngular);

        Double x = ferengi.getDistanciaAlSol() * Math.cos(Math.toRadians(posicioAngular));
        Double y = ferengi.getDistanciaAlSol() * Math.sin(Math.toRadians(posicioAngular));

        Assert.assertEquals(ferengi.getPosicionAngular().longValue(), 90L) ;
        Assert.assertEquals(ferengi.getPunto().getX().doubleValue() , 0D, 0D);
        Assert.assertEquals(ferengi.getPunto().getY().doubleValue() , 5D, 0D);
        Assert.assertEquals(x.intValue(), 0, 0D);
        Assert.assertEquals(y , 5D, 0D);
    }

    @Test
    public void calcularPuntosPrimerDia(){

        ferengi.desplazate();
        betasoide.desplazate();
        vulcano.desplazate();

        Assert.assertEquals(ferengi.getPunto().getX() , BigDecimal.valueOf(8.7));
        Assert.assertEquals(ferengi.getPunto().getY() ,  BigDecimal.valueOf(500.0));

        Assert.assertEquals(betasoide.getPunto().getX().doubleValue() , 104.6, 0D);
        Assert.assertEquals(betasoide.getPunto().getY().doubleValue() , 1997.3, 0D);

        Assert.assertEquals(vulcano.getPunto().getX().doubleValue() , -87.1, 0D);
        Assert.assertEquals(vulcano.getPunto().getY().doubleValue() , 996.2, 0D);

    }

    @Test
    public void calcularPuntosEnUnaRectaPrimerDia(){

        Double result = (vulcano.getPunto().getX().doubleValue()- ferengi.getPunto().getX().doubleValue()) * (betasoide.getPunto().getY().doubleValue()- vulcano.getPunto().getY().doubleValue());
        Double result2 = (vulcano.getPunto().getY().doubleValue()- ferengi.getPunto().getY().doubleValue()) * (betasoide.getPunto().getX().doubleValue()-vulcano.getPunto().getX().doubleValue() );

        Assert.assertEquals(result, result2);
        Assert.assertTrue(
                estanAlineados( ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                                vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                                betasoide.getPunto().getX(), betasoide.getPunto().getY()  ));

    }

    @Test
    public void verificarPuntoInteriorEnTriangulo(){

    //(A1.x - A3.x) * (A2.y - A3.y) - (A1.y - A3.y) * (A2.x - A3.x)
    //Si el resultado es mayor o igual que 0, la orientación del triángulo será positiva

        //Se calcula la orientación de los triángulos A1A2P, A2A3P, A3A1P
        //si son todas posivas o todas negativas dependiendo de la orientacion principal
        //entonces el punto P se encuentra dentro del triangulo.

        ferengi.desplazate();
        betasoide.desplazate();
        vulcano.desplazate();

        Boolean orientacionInicial =
                calcularOrientacion(ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                                    vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                                    betasoide.getPunto().getX(), betasoide.getPunto().getY());

        Boolean orientacionA1A2P =
                calcularOrientacion(ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                        vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                        new BigDecimal(0), new BigDecimal(0) );

        Boolean orientacionA2A3P =
                calcularOrientacion(vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                        betasoide.getPunto().getX(), betasoide.getPunto().getY(), new BigDecimal(0), new BigDecimal(0));

        Boolean orientacionA3A1P =
                calcularOrientacion(ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                        betasoide.getPunto().getX(), betasoide.getPunto().getY(), new BigDecimal(0), new BigDecimal(0));


        Assert.assertFalse(orientacionInicial);
        Assert.assertEquals(orientacionA1A2P, true);
        Assert.assertEquals(orientacionA2A3P, false);
        Assert.assertEquals(orientacionA3A1P, false);

    }

    @Test
    public void verificarPerimetroTriangulo(){
        ferengi.desplazate();
        betasoide.desplazate();
        vulcano.desplazate();

        BigDecimal perimetro = calcularPerimetro(ferengi.getPunto().getX(), ferengi.getPunto().getY(),
                                             vulcano.getPunto().getX(),vulcano.getPunto().getY(),
                                             betasoide.getPunto().getX(), betasoide.getPunto().getY());

        Assert.assertEquals(perimetro.setScale(2, BigDecimal.ROUND_UP), BigDecimal.valueOf(3025.03 ));

    }

    private Boolean estanAlineados(BigDecimal x1 , BigDecimal y1 , BigDecimal x2 , BigDecimal y2, BigDecimal x3 , BigDecimal y3 ){

        BigDecimal calculo1 = x2.subtract(x1).multiply( ( y3.subtract(y2)) );
        BigDecimal calculo2 = y2.subtract(y1).multiply( ( x3.subtract(x2)) );

        //Double result = (x2-x1)*(y3-y2);
        //Double result1 = (y2-y1)*(x3-x2);

        return calculo1.compareTo(calculo2) == 0;
    }

    private Boolean calcularOrientacion(BigDecimal x1 , BigDecimal y1 , BigDecimal x2 , BigDecimal y2, BigDecimal x3 , BigDecimal y3){
        BigDecimal calculo1 = x1.subtract(x3).multiply( ( y2.subtract(y3)) );
        BigDecimal calculo2 = y1.subtract(y3).multiply( ( x2.subtract(x3)) );

        BigDecimal result = calculo1.subtract(calculo2);
        return ( result.compareTo(BigDecimal.ZERO) > 0 || result.compareTo(BigDecimal.ZERO) == 0 ) ;
    }

    private BigDecimal calcularPerimetro(BigDecimal x1 , BigDecimal y1 , BigDecimal x2 , BigDecimal y2, BigDecimal x3 , BigDecimal y3){
        BigDecimal ladoAB = calcularLados(x1, y1, x2, y2);
        BigDecimal ladoAC = calcularLados(x1, y1, x3, y3);
        BigDecimal ladoBC = calcularLados(x2, y2, x3, y3);
        return ladoAB.add(ladoAC).add(ladoBC);
    }

    private BigDecimal calcularLados(BigDecimal x1 , BigDecimal y1 , BigDecimal x2 , BigDecimal y2){

        return new BigDecimal(Math.sqrt( Math.pow( (x2.doubleValue()-x1.doubleValue()), 2 ) + Math.pow( (y2.doubleValue()-y1.doubleValue()), 2 ) ));
    }
}
