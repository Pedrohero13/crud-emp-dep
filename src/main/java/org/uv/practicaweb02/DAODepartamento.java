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
public class DAODepartamento implements IDAOGeneral<Departamento, Integer> {

    @Override
    public boolean guardar(Departamento pojo) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "INSERT INTO departamento (clave,nombre) values ('" + pojo.getClave() + "','" + pojo.getNombre() + "') ";
        return con.execute(sql);
    }

    @Override
    public boolean modificar(Departamento pojo, Integer id) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "UPDATE departamento SET nombre ='" + pojo.getNombre() + "' WHERE clave = '" + id + "'";
        return con.execute(sql);
    }

    @Override
    public boolean eliminar(Integer id) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "DELETE FROM departamento WHERE clave = '" + id + "'";
        return con.execute(sql);
    }

    @Override
    public Departamento buscarById(Integer id) {
        try {
            ConexionDB con = ConexionDB.getInstance();
            
            String sql = "SELECT ¨* FROM departamento WHERE clave = '"+id+"'";
            
            ResultSet  reg =  con.query(sql);
            Departamento dep = new Departamento();
            if(reg.next()){
                dep.setClave(reg.getInt("clave"));
                dep.setNombre(reg.getString("nombre"));
                
            }
            return dep;
        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public List<Departamento> buscarTodos() {
        try {
            ConexionDB con = ConexionDB.getInstance();
            String sql = "SELECT * FROM departamento ORDER BY clave";
            List<Departamento> lstDepartamento = new ArrayList<>();
            
            ResultSet reg = con.query(sql);
            while(reg.next()){
                Departamento dep = new Departamento();
                dep.setClave(reg.getInt("clave"));
                dep.setNombre(reg.getString("nombre"));
                lstDepartamento.add(dep);
                
            }
            return lstDepartamento;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }

}
