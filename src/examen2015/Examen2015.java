/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2015;

import java.io.IOException;

/**
 *
 * @author Jose Luis
 */
public class Examen2015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Empresa examen=new Empresa(1);
        examen.pedirDatos();
         examen.informe();
    }
    
}
