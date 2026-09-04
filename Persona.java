/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebal
 */
public class Persona {
    private String rut;
    private String estadoCivil;
    private Domicilio zonaGeo;
    private Estado datosPer;
    
    public Persona(String rutPer, String sitCivil, Domicilio vivienda, Estado vive){
        this.rut = rutPer;
        this.estadoCivil = sitCivil;
        this.zonaGeo = new Domicilio(vivienda.getRegion(), vivienda.getComuna());
        this.datosPer = new Estado(vive.getNacimiento(), vive.getLugarNacimiento(), vive.getFallecido());
    }
}
