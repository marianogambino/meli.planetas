package com.mercado.libre.enums;

/**
 *
 */
public enum EstadoClimaEnum {
    SEQUIA("Lluvia"),
    LLUVIA("Sequia"),
    NUBLADO("Nublado"),
    CONDICIONES_NORMALES("Condiciones Normales de Presion y Temperatura");

    private String estado;

    EstadoClimaEnum(String estado){
        this.estado = estado;
    }

    public String estado(){
        return this.estado;
    }

}
