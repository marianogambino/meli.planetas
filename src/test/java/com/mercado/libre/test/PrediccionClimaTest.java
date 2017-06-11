package com.mercado.libre.test;

import com.mercado.libre.model.Betasoide;
import com.mercado.libre.model.Ferengi;
import com.mercado.libre.model.Planetable;
import com.mercado.libre.model.Vulcano;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class PrediccionClimaTest {

    private Planetable ferengi = new Ferengi();
    private Planetable betasoide = new Betasoide( );
    private Planetable vulcano = new Vulcano();

    @Before
    public void setUp(){

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

        Assert.assertEquals(ferengi.getPunto().getX().doubleValue() , 0.087262032186418D, 0D);
        Assert.assertEquals(ferengi.getPunto().getY().doubleValue() , 4.999238475781956, 0D);

        Assert.assertEquals(betasoide.getPunto().getX().doubleValue() , 1.0467191248588794, 0D);
        Assert.assertEquals(betasoide.getPunto().getY().doubleValue() , 19.972590695091476D, 0D);

        Assert.assertEquals(vulcano.getPunto().getX().doubleValue() , -0.8715574274765824D, 0D);
        Assert.assertEquals(vulcano.getPunto().getY().doubleValue() , 9.961946980917455D, 0D);

    }

    @Test
    public void calcularPuntosEnUnRectaPrimerDia(){
        ferengi.desplazate();
        betasoide.desplazate();
        vulcano.desplazate();
        Double result = (vulcano.getPunto().getX().doubleValue()- ferengi.getPunto().getX().doubleValue()) * (betasoide.getPunto().getY().doubleValue()- vulcano.getPunto().getY().doubleValue());
        Double result2 = (vulcano.getPunto().getY().doubleValue()- ferengi.getPunto().getY().doubleValue()) * (betasoide.getPunto().getX().doubleValue()-vulcano.getPunto().getX().doubleValue() );

        Assert.assertNotEquals(result, result2);
        Assert.assertFalse(estanAlineados( ferengi.getPunto().getX(), ferengi.getPunto().getY(), vulcano.getPunto().getX(),vulcano.getPunto().getY(), betasoide.getPunto().getX(), betasoide.getPunto().getY()  ));

    }

    @Test
    public void verificarPuntoInteriorEnTriangulo(){

    //(A1.x - A3.x) * (A2.y - A3.y) - (A1.y - A3.y) * (A2.x - A3.x)
    //Si el resultado es mayor o igual que 0, la orientación del triángulo será positiva

        //Se calcula la orientación de los triángulos A1A2P, A2A3P, A3A1P
        //si son todas posivas o todas negativas dependiendo de la orientacion principal
        //entonces el punto P se encuentra dentro del triangulo.



    }

    private Boolean estanAlineados(Double x1 , Double y1 , Double x2 , Double y2, Double x3 , Double y3 ){
        Double result = (x2-x1)*(y3-y2);
        Double result1 = (y2-y1)*(x3-x2);
        return result==result1;
    }

}
