/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebal
 */
public class Domicilio {
    private bool extranjero;
    private String region;
    private String comuna;
    
    public Domicilio(bool extranjero){
        this.region = "Extranjero";
        this.comuna = "Extranjero";
    }
    
    public Domicilio(String r, String c){
        this.region = r;
        this.comuna = c;
    }
    
    public void setAlgo(){
        this. = 
    }

    public void setAlgo(){
        this. = 
    }
    
    public void cambioDomicilio(String r, String c){
        System.out.println("Su region fué cambiada a :" + r);
        this.region = r;
        System.out.println("Su comuna fue cambiada a :" + c);
        this.comuna = c;
    }
}
