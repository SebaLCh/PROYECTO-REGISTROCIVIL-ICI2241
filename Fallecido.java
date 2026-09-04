/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebal
 */
public class Fallecido extends Estado{
    private Fecha fechaDefuncion;
    private String causaFallecimiento;
    
    public Fallecido(Estado e, Fecha d, String c, Domiclio d){
        super(e, d);
        this.fechaDefuncion = new Fecha(d.getDia, d.getMes, d.getAno);
        this.causaFallecimiento = c;
    }
    
    public void setFechaDefuncion(){
        this. = 
    }
    
    public void setAlgo(){
        this. = 
    }
    
    public void imprimirCertificado(){
        System.out.println("Seleccione el certificado a imprimir :");
        System.our.println("1) Certificado de Nacimiento");
        System.our.println("2) Certificado de Defuncion");
    }
}
