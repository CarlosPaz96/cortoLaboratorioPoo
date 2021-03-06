/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Filtro;

/**
 *
 * @author LN710Q
 */
public class FiltroDao implements metodos<Filtro>{
     private static final String SQL_INSERT = "INSERT INTO mascotas (ninscripcion,nombre,edad,raza, propietario) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE mascotas SET propietario = ?, nombre = ?, edad = ?,raza=?  WHERE ninscripcion = ?";
    private static final String SQL_DELETE = "DELETE FROM mascotas WHERE ninscrpcion = ?";
    private static final String SQL_READ = "SELECT * FROM mascotas";
    private static final String SQL_READALL = "SELECT * FROM mascotas";
    private static final Conexion conex = Conexion.conectar();

    @Override
    public boolean create(Filtro f) {
        PreparedStatement PreStat;
        try {
            PreStat = conex.getCnx().prepareStatement(SQL_INSERT);
            PreStat.setString(1, f.getNinscripcion());
            PreStat.setString(2, f.getRaza());
            PreStat.setString(5, f.getNombre());
            PreStat.setString(6, f.getPropietario());
            PreStat.setInt(3, f.getEdad());
            PreStat.setBoolean(4, true);
            if (PreStat.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conex.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = conex.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conex.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Filtro c) {
        PreparedStatement ps;
        try {
            System.out.println(c.getNinscripcion());
            ps = conex.getCnx().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getRaza());
            ps.setInt(2, c.getEdad());
            ps.setBoolean(3, c.getExistencia());
            ps.setString(4, c.getNombre());
            ps.setString(5, c.getPropietario());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conex.cerrarConexion();
        }
        return false;
    }

    @Override
    public Filtro read(Object key) {
        Filtro f = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conex.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                f = new Filtro(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5) , rs.getBoolean(6));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conex.cerrarConexion();
        }
        return f;
    }

    @Override
    public ArrayList<Filtro> readAll() {
        ArrayList<Filtro> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try {
            s = conex.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            while(rs.next()){
                all.add(new Filtro(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5) , rs.getBoolean(6)));
            }
            rs.close();
        } catch (SQLException ex) {
           Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            conex.cerrarConexion();
        }
        return all;
    }
    
    
}
