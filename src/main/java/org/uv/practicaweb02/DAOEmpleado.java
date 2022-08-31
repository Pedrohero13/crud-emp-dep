/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.practicaweb02;

import java.util.List;

/**
 *
 * @author Pedro
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Integer>{

    @Override
    public boolean guardar(Empleado pojo) {
        ConexionDB con = ConexionDB.getInstance();
         String sql = "insert into empleado(clave, nombre,direccion, telefono)"
                + "values ('"+pojo.getClave()+"','"+pojo.getNombre()+"','"+pojo.getDireccion()+"'"
                + ",'"+pojo.getTelefono()+"')";
        return con.execute(sql);
    }

    @Override
    public boolean modificar(Empleado pojo, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado buscarById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
