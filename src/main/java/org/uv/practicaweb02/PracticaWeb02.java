/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.uv.practicaweb02;

import java.util.List;
import java.util.Scanner;
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
        Scanner teclado = new Scanner(System.in);
        IDAOGeneral<Empleado, Integer> daoEmpleado = FactoryDAO.create(FactoryDAO.TYPE.EMPLEADO);
        IDAOGeneral<Departamento, Integer> daoDepartamento = FactoryDAO.create(FactoryDAO.TYPE.DEPARTAMENTO);

        Empleado empleado = null;
        Departamento departamento = null;
        boolean bandera = true;
        boolean banMenu = true;
        while (banMenu) {
            System.out.println(
                    "----Menu de Principal----\n"
                    + "******* 1 Empleados ******* \n"
                    + "******* 2 Departamentos ******** \n"
                    + "******* 3 Salir *********");
            String menu = teclado.nextLine();
            switch (menu) {
                case "1":
                    while (bandera) {
                        System.out.println(
                                "----Menu de Empleados----\n"
                                + "******* 1 Agregar ******* \n"
                                + "******* 2 Buscar ******** \n"
                                + "******* 3 Consultar ***** \n"
                                + "******* 4 Modificar ***** \n"
                                + "******* 5 Eliminar ****** \n"
                                + "******* 6 Salir *********");
                        String opcion = teclado.nextLine();

                        switch (opcion) {
                            case "1":
                                empleado = new Empleado();
                                System.out.println("Menu para agregar un empleado!");
                                System.out.println("Clave: ");
                                empleado.setClave(Integer.parseInt(teclado.nextLine()));
                                System.out.println("Nombre: ");
                                empleado.setNombre(teclado.nextLine());
                                System.out.println("Dirección: ");
                                empleado.setDireccion(teclado.nextLine());
                                System.out.println("Telefono: ");
                                empleado.setTelefono(teclado.nextLine());

                                if (daoEmpleado.guardar(empleado)) {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.INFO, "Se guardo");
                                } else {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.WARNING, "¡Error!");
                                }
                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "2":

                                System.out.println("Menu para buscar por clave a un empleado!");
                                System.out.println("Clave: ");
                                int clave = Integer.parseInt(teclado.nextLine());

                                empleado = daoEmpleado.buscarById(clave);
                                if (empleado != null) {
                                    System.out.println("Nombre: " + empleado.getNombre() + " Dirección: " + empleado.getDireccion());

                                } else {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.WARNING, "Empleado no encontrado");

                                }

                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "3":
                                System.out.println("Menu para Buscar a todos los empleados!");
                                List<Empleado> lstEmpleado = daoEmpleado.buscarTodos();
                                for (Empleado emp : lstEmpleado) {
                                    System.out.println("Clave: " + emp.getClave() + " Nombre: " + emp.getNombre() + " Dirección: " + emp.getDireccion());
                                }
                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "4":
                                empleado = new Empleado();
                                System.out.println("Menu para modificar un empleado!");
                                System.out.println("Clave valida: ");
                                int id = Integer.parseInt(teclado.nextLine());
                                System.out.println("Nombre: ");
                                empleado.setNombre(teclado.nextLine());
                                System.out.println("Dirección: ");
                                empleado.setDireccion(teclado.nextLine());
                                System.out.println("Telefono: ");
                                empleado.setTelefono(teclado.nextLine());

                                if (daoEmpleado.modificar(empleado, id)) {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.INFO, "Se Modifico");
                                } else {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.WARNING, "¡Error!");
                                }
                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "5":
                                System.out.println("Menu para Borrar por clave a un empleado!");
                                System.out.println("Clave (valida): ");
                                clave = Integer.parseInt(teclado.nextLine());
                                if (daoEmpleado.eliminar(clave)) {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.INFO, "Se Elimino");
                                } else {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.WARNING, "¡Error!");
                                }

                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "6":
                                System.out.println("BYE!");
                                bandera = false;
                        }

                    }
                    break;
                case "2":
                    while (bandera) {
                        System.out.println(
                                "----Menu de Empleados----\n"
                                + "******* 1 Agregar ******* \n"
                                + "******* 2 Buscar ******** \n"
                                + "******* 3 Consultar ***** \n"
                                + "******* 4 Modificar ***** \n"
                                + "******* 5 Eliminar ****** \n"
                                + "******* 6 Salir *********");
                        String opcion = teclado.nextLine();

                        switch (opcion) {
                            case "1":
                                departamento = new Departamento();
                                System.out.println("Menu para agregar un departamento!");
                                System.out.println("Clave: ");
                                departamento.setClave(Integer.parseInt(teclado.nextLine()));
                                System.out.println("Nombre: ");
                                departamento.setNombre(teclado.nextLine());

                                if (daoDepartamento.guardar(departamento)) {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.INFO, "Se guardo");
                                } else {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.WARNING, "¡Error!");
                                }
                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "2":

                                System.out.println("Menu para buscar por clave a un departamento!");
                                System.out.println("Clave: ");
                                int clave = Integer.parseInt(teclado.nextLine());

                                departamento = daoDepartamento.buscarById(clave);
                                if (departamento != null) {
                                    System.out.println("Nombre: " + departamento.getNombre());

                                } else {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.WARNING, "Departamento no encontrado");

                                }

                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "3":
                                System.out.println("Menu para Buscar a todos los departamentos!");
                                List<Departamento> lstDepartamento = daoDepartamento.buscarTodos();
                                for (Departamento emp : lstDepartamento) {
                                    System.out.println("Clave: " + emp.getClave() + " Nombre: " + emp.getNombre());
                                }
                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "4":
                                departamento = new Departamento();
                                System.out.println("Menu para modificar un departamento!");
                                System.out.println("Clave valida: ");
                                int id = Integer.parseInt(teclado.nextLine());
                                System.out.println("Nombre: ");
                                departamento.setNombre(teclado.nextLine());

                                if (daoDepartamento.modificar(departamento, id)) {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.INFO, "Se Modifico");
                                } else {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.WARNING, "¡Error!");
                                }
                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "5":
                                System.out.println("Menu para Borrar por clave a un departamento!");
                                System.out.println("Clave (valida): ");
                                clave = Integer.parseInt(teclado.nextLine());
                                if (daoDepartamento.eliminar(clave)) {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.INFO, "Se Elimino");
                                } else {
                                    Logger.getLogger(PracticaWeb02.class.getName()).log(Level.WARNING, "¡Error!");
                                }

                                System.out.println("\nEnter para regresar al menu");
                                teclado.nextLine();
                                break;
                            case "6":
                                System.out.println("BYE!");
                                bandera = false;
                        }

                    }
                    break;
                case "3":
                    banMenu= false;
                    break;

            }
        }

    }

}
