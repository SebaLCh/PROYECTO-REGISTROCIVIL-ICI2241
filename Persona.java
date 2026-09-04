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
    private String comuna
    private Estado datosPer;
    
    public Persona(String rutPer, String sitCivil, String c, Estado vive){
        this.rut = rutPer;
        this.estadoCivil = sitCivil;
        this.comuna = c;
        this.datosPer = new Estado(vive.getNacimiento(), vive.getLugarNacimiento(), vive.getFallecido());
    }

    public void setRut(String r){
        this.rut = r; 
    }

    public void setEstadoCivil(String e){
        this.estadoCivil = e; 
    }
    
    public void setComuna(String c){
        this.comuna = c;
    }
    
    public void acreditarFallecimiento(){
    
    }
}
