/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2015;
import numeros.Numeros;
import datos.Datos;
import java.io.IOException;
/**
 *
 * @author Jose Luis
 */
public class Empresa {
    Empleado[]empleados;
    Zona[]zonas={
        new Zona(2000,"Castilla y Leon"),
        new Zona(2200,"Andalaucia"),
        new Zona(2500,"Levansadfs<fds<fds<e"),
        
    };
    String[]situaciones={"Soltero","Casado","Otros"};
    float[]limites={3000f,5000f,10000f,Float.MAX_VALUE};
    float[][]irpf={{0.1f,0.15f,0.2f,0.25f},
                {0.12f,0.14f,0.16f,0.18f},
                 {0.05f,0.07f,0.1f,0.15f}};
    Fecha fAlta;

   public Empresa(int nEmpleado){
        empleados = new Empleado[nEmpleado];
    }
   public void pedirDatos() throws IOException{
       String nombre;
       int codZona;
       int sitPersonal;
       Fecha fecha=new Fecha();
        for (int e=0;e<empleados.length;e++)
        {
             
             nombre=Datos.pedirDato("Introduce el nombre del empleado");
             empleados[e].setNombre(nombre);
             
             visualizarZona();
             codZona=Numeros.pedirNumeroEntero(0,zonas.length-1,"");
             empleados[e].setCodZona(codZona);
             visualizarSitPersonal();
             
             sitPersonal=Numeros.pedirNumeroEntero(0,2,"");
             empleados[e].setSitPersonal(sitPersonal);
             
             System.out.println("Introduce fecha de alta");
             int dia,mes,ano;
             dia=Numeros.pedirNumeroEntero(1,31,"Dia");
             mes=Numeros.pedirNumeroEntero(1,12,"Mes");
             ano=Numeros.pedirNumeroEntero(1990,"Ano");
            
            
             //Comprobar fecha
             while(!fecha.correctaFecha(dia, mes, ano))
             {
                 
                    dia=Numeros.pedirNumeroEntero(1,31,"Feecha incorrecta, vuelve a introducir Dia");
                        mes=Numeros.pedirNumeroEntero(1,12,"Mes");
                        ano=Numeros.pedirNumeroEntero(1990,"Ano");
                   
             }
             
             fAlta=new Fecha(dia,mes,ano);
             empleados[e].setfAlta(fAlta);
             
            // fAlta.calcularQuinquenios(fAlta);
             
             //Pedir ventas
             for(int i=0;i<3;i++)
                 
             {
                 float venta=Numeros.pedirNumeroEntero(0,"Introducir ventas del mes "+(i+1));
                 empleados[e].setUnaVenta(i, venta);
             }
             
             
            
        }
   }

   
    private void visualizarZona() {
           System.out.println("Introduce la zona");
       for (int z = 0; z < zonas.length; z++) {
            System.out.print(z+ "--" +zonas[z].getDenominacion()+"\t");
    }
    }
    private void visualizarSitPersonal(){
           System.out.println("Introduce la situacion personal:");
           for(int s=0;s<situaciones.length;s++){
                  System.out.print(s+"--"+situaciones[s]+"\t");
           }
    }
    public int calcularAntiguedad(int e){
       // int quinquenios = fAlta.calcularQuinquenios(fAlta);
        int quinquenios=empleados[e].getfAlta().calcularQuinquenios();
        int antiguedad = quinquenios*10;
        return antiguedad;
    }
    public float sueldoBruto(int e){
        float sbruto=0;
        sbruto=empleados[e].totalVentas()*0.10f;
        int sbase=zonas[empleados[e].getCodZona()].getSueldo();
        float total=sbruto+sbase+calcularAntiguedad(e);        
        return total;
    }
    public float sueldoNeto(int e){
        float sb=sueldoBruto(e);
        int limite=buscarLimite(sb);
        float retencion=irpf[empleados[e].getSitPersonal()][limite];
        
        float sueldoNeto=sb-sb*retencion;
        return sueldoNeto;
        
    }
      public  int buscarLimite(float importe){    
        
        int pos = 0;
        boolean encontrado=false;
        
        while(!encontrado && pos<limites.length)
        {
            if(importe<limites[pos])
            {
            encontrado=true;
            }
            else
            {
            pos++;
            }            
        }
       
        return pos;
    
    }

    public void informe(){
        System.out.println("Zona"+"\t"+"Nombre empleado:"+"\t"+"F.Alta;"+"\t"+"Ventas:"+"\t"+"Total Ventas:"+"\t"+"Sueldo a percibir:");
        for(int e=0;e<empleados.length;e++)
        {
             System.out.print(zonas[empleados[e].getCodZona()].getDenominacion()+"\t"+empleados[e].getNombre()+"\t\t"+empleados[e].visualizarFecha()+"\t\t"+empleados[e].mostrarVentas()+"\t"+empleados[e].totalVentas()+"\t"+sueldoNeto(e));
              
        }
        
    }

    
}
