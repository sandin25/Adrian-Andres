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
public class Empleado {
    private String nombre;
    private int codZona;
    private int sitPersonal;
    private Fecha fAlta;
    private float[] ventas =new float[3];

    
    Esto es una prueba

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodZona() {
        return codZona;
    }

    public void setCodZona(int codZona) {
        this.codZona = codZona;
    }

      public String visualizarFecha() {
         String fecha= fAlta.visualizar();
        return fecha;
    }
      
      public Fecha getfAlta() {
               return fAlta;
    }

    public void setfAlta(Fecha fAlta) {
        this.fAlta = fAlta;
    }

    public float[] getVentas() {
        return ventas;
    }

    public void setVentas(float[] ventas) {
        this.ventas = ventas;
    }
    
    public void setUnaVenta(int mes,float venta) {
        this.ventas[mes]=venta;
    }

    public int getSitPersonal() {
        return sitPersonal;
    }

    public void setSitPersonal(int sitPersonal) {
        this.sitPersonal = sitPersonal;
    }
    
    public float totalVentas(){
        float total=0;
        for(int v =0;v<ventas.length;v++)
        {
            total=total+ventas[v];
        }
        return total;
        
    }

    public String mostrarVentas() {
       String ventasMes="";
       for(int i=0;i<ventas.length;i++){
           ventasMes=ventasMes+"- "+ventas[i];
       }
       return ventasMes;
    }
}
