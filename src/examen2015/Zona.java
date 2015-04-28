/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2015;

/**
 *
 * @author Jose Luis
 */
public class Zona {
     private int sueldo;
     private String denominacion;
     

    public Zona(int s, String d) {
        this.sueldo = s;
        this.denominacion = d;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }


   
}
