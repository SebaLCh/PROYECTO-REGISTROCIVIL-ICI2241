/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebal
 */
public class Estado {
    protected Fecha nacimiento;
    protected Domicilio lugarNacimiento;
    protected bool fallecido;
    
    public Estado(Fecha n, Domicilio l){
        this.nacimiento = new Fecha(n.getDia(), n.getMes(), n.getAno());
        this.lugarNacimiento = new Domicilio(l.getRegion(), l.getComuna());
    }
    
    public void imprimirCertificado(){
    }

}
