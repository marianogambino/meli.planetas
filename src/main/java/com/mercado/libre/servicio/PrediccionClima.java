package com.mercado.libre.servicio;

import com.mercado.libre.Resolution.Result;
import com.mercado.libre.enums.EstadoClimaEnum;
import com.mercado.libre.model.Betasoide;
import com.mercado.libre.model.Ferengi;
import com.mercado.libre.model.Planetable;
import com.mercado.libre.model.Vulcano;
import com.mercado.libre.strategy.PuntosAlineadosStrgy;
import com.mercado.libre.strategy.Strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class PrediccionClima implements Predecible {

    private Strategy strategy;

    private Planetable ferengi = new Ferengi();
    private Planetable betasoide = new Betasoide();
    private Planetable vulcano = new Vulcano();

    private Map<Integer, EstadoClimaEnum> diasEstados = new HashMap<Integer, EstadoClimaEnum>();
    private Map<EstadoClimaEnum, List<List<Integer>>> periodos = new HashMap<EstadoClimaEnum, List<List<Integer>>>();

    private Double perimetroMax = 0D;
    private Integer diaMaxLluvia = 0;
    private final static Integer RAD_360 = 360;

    public PrediccionClima(){
        periodos.put(EstadoClimaEnum.CONDICIONES_NORMALES, new ArrayList<List<Integer>>());
        periodos.put(EstadoClimaEnum.SEQUIA, new ArrayList<List<Integer>>());
        periodos.put(EstadoClimaEnum.LLUVIA, new ArrayList<List<Integer>>());
        this.strategy = new PuntosAlineadosStrgy();
    }


    @Override
    public void predecir(Integer anios, Integer velocidadAngular) {
        Integer dias = anios * (RAD_360/velocidadAngular);
        for(int i=1; i<=dias; i++) {

            ferengi.desplazate();
            vulcano.desplazate();
            betasoide.desplazate();
            //si estan alineados
            Result result = this.strategy.execute(ferengi,vulcano,betasoide);
            diasEstados.put(i,result.getEstado());

            if(result.getPerimetro() > perimetroMax){
                perimetroMax = result.getPerimetro();
                diaMaxLluvia = i;
            }

            //diasEstados.get(i-1) == estado;
                //periodos.get(estado).get(periodos.get(estado).size-1).add(i);
            //else
                //lista = new arraylist().add(i)
            //periodos.get(estado).get().add(lista);
        }
    }

    @Override
    public Map<Integer, EstadoClimaEnum> getDiasEstado() {
        return diasEstados;
    }

    @Override
    public Integer getDiaMaxLluvia() {
        return diaMaxLluvia;
    }

    @Override
    public Integer getCantPeriodosSequia() {
        return periodos.get(EstadoClimaEnum.SEQUIA).size();
    }

    @Override
    public Integer getCantPeriodosLluvia() {
        return periodos.get(EstadoClimaEnum.LLUVIA).size();
    }

    @Override
    public Integer getCantPeriodosCOPT() {
        return periodos.get(EstadoClimaEnum.CONDICIONES_NORMALES).size();
    }
}
