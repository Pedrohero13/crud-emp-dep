/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.practicaweb02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ConexionDB con = ConexionDB.getInstance();
        String sql = "UPDATE empleado SET nombre= '"+pojo.getNombre()+"', direccion="
                + "'"+pojo.getDireccion()+"', telefono='"+pojo.getTelefono()+"' "
                + "WHERE clave = '"+pojo.getClave()+"'";
        return con.execute(sql);
    }

    @Override
    public boolean eliminar(Integer id) {
        ConexionDB con = ConexionDB.getInstance();
        String sql= "DELETE FROM empleado WHERE clave = '"+id+"'";
        return con.execute(sql);
    }

    @Override
    public Empleado buscarById(Integer id) {
        ConexionDB con = ConexionDB.getInstance();
        try {
            String sql ="Select * from empleado where clave='"+id+"'";
            Empleado empleado = new Empleado();
            ResultSet reg=con.query(sql);
            if(reg.next()){
                empleado.setClave(reg.getInt("clave"));
                empleado.setNombre(reg.getString("nombre"));
                empleado.setDireccion(reg.getString("direccion"));
                empleado.setTelefono(reg.getString("telefono"));
                return empleado;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Empleado> buscarTodos() {
        ConexionDB con = ConexionDB.getInstance();
        try {
            String sql ="Select * from empleado";
            List<Empleado> lstEmpleado= new ArrayList<>();
            ResultSet reg=con.query(sql);
            while(reg.next()){
                Empleado empleado = new Empleado();
                empleado.setClave(reg.getInt("clave"));
                empleado.setNombre(reg.getString("nombre"));
                empleado.setDireccion(reg.getString("direccion"));
                empleado.setTelefono(reg.getString("telefono"));
                lstEmpleado.add(empleado);
            }
            return lstEmpleado;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
