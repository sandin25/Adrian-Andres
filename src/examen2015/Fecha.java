/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2015;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author 203P30
 */
public class Fecha {

    private int dia;
    private int mes;
    private int ano;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Fecha getFecha() {
        /*    Fecha f=new Fecha();
         f.dia=this.dia;
         f.mes=this.mes;
         f.ano=this.ano;
         return f;*/
        return this;
    }

    public void setFecha(Fecha f) {
        this.dia = f.dia;
        this.mes = f.mes;
        this.ano = f.ano;

    }

    public Fecha() {
        GregorianCalendar f = new GregorianCalendar();
        this.dia = f.get(Calendar.DATE);
        mes = f.get(Calendar.MONTH) + 1;
        ano = f.get(Calendar.YEAR);
    }

    public Fecha(int d, int m, int a) {
        dia = d;
        mes = m;
        ano = a;
    }

    public boolean correctaFecha(int d, int m, int a) {
        boolean esCorrecta = false;
        int[] diaMes = {0, 31, 28, 30, 31, 30, 31, 30, 31, 30, 31, 30, 31};
        if (a >= 0) {
            if (esBisiesto(a)) {
                diaMes[2] = 29;
            } else {
                diaMes[2] = 28;
            }
            if (m >= 1 && m <= 12) {
                if (d >= 1 && d <= diaMes[m]) {
                    esCorrecta = true;
                    dia = d;
                    mes = m;
                    ano = a;

                }
            }

        }
        return esCorrecta;
    }

    public boolean esBisiesto() {
        boolean bisiesto = false;
        if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) {
            bisiesto = true;
        }

        return bisiesto;
    }

    public boolean esBisiesto(int a) {
        boolean bisiesto = false;
        if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) {
            bisiesto = true;
        }

        return bisiesto;
    }

    public int CompararFechas(Fecha f2) {
        int resultado = 0;
        if (this.dia == f2.getDia() && this.mes == f2.getMes() && this.ano == f2.getAno()) {
            resultado = 0;//Iguales
        } else {
            if (this.ano < f2.getAno()) {
                resultado = 1;
            } else {
                if (this.ano == f2.getAno()) {
                    resultado = 2;
                } else {//elmismo año
                    if (this.mes < f2.getAno()) {
                        resultado = 1;
                    } else {
                        if (this.mes == f2.getMes()) {
                            resultado = 2;
                        } else {//mismo mes y mismo año
                            if (this.dia < f2.getDia()) {
                                resultado = 1;
                            } else {
                                resultado = 2;
                            }
                        }//mismo mes y mismo año
                    }
                }//mismo año
            }
        }
        return resultado;
    }

    public int CalcularNumeroAños() {
        Fecha fhoy = new Fecha();
        int nanos = fhoy.getAno() - this.getAno();
        if (fhoy.getMes() < this.mes || fhoy.getMes() == this.mes && fhoy.getDia() < this.dia) {
            nanos--;
        }
            return nanos;
    }
    public String visualizar()
    {
        return dia +"-"+ mes +"-"+ ano;
    }
    
    /* public int calcularQuinquenios(Fecha fAlta) {
        Fecha fhoy = new Fecha();
        int nanos = fhoy.getAno() - fAlta.getAno();
        if (fhoy.getMes() < fAlta.mes || fhoy.getMes() == fAlta.mes && fhoy.getDia() < fAlta.dia) {
            nanos--;
            
        }
            nanos=nanos/5;
            return nanos;
    }*/
    
    public int calcularQuinquenios() {
        Fecha fhoy = new Fecha();
        int nanos = fhoy.getAno() - this.getAno();
        if (fhoy.getMes() < this.mes || fhoy.getMes() == this.mes && fhoy.getDia() < this.dia) {
            nanos--;
            
        }
            nanos=nanos/5;
            return nanos;
    }
   
}
