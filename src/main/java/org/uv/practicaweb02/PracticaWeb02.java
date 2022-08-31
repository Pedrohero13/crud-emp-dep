/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.uv.practicaweb02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class PracticaWeb02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empleado empleado = new Empleado();
        empleado.setClave(6);
        empleado.setNombre("Arturo");
        empleado.setDireccion("AV 121");
        empleado.setTelefono("23138921");
        IDAOGeneral<Empleado, Integer> dao = FactoryDAO.create(FactoryDAO.TYPE.EMPLEADO);

        if (dao.guardar(empleado)) {
            Logger.getLogger(PracticaWeb02.class.getName()).log(Level.INFO, "Se guardo");
        } else {
            Logger.getLogger(PracticaWeb02.class.getName()).log(Level.WARNING, "¡Error!");
        }
    }

}
