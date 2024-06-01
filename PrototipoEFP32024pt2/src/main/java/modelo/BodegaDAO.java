/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Bodega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author Leticia
 */
public class BodegaDAO {
    
    
    private static final String SQL_SELECT = "SELECT Pkid, tipo_bodega, nombre, direccion, estado FROM bodega";
    private static final String SQL_INSERT = "INSERT INTO bodega(Pkid, tipo_bodega, nombre, direccion, estado) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE bodega SET tipo_bodega=?, nombre=?, direccion=?, estado=? WHERE Pkid = ?";
    private static final String SQL_DELETE = "DELETE FROM bodega WHERE Pkid=?";
    private static final String SQL_QUERY = "SELECT tipo_bodega, nombre, direccion, estado FROM bodega WHERE Pkid = ?";

    public List<Bodega> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bodega bodega = null;
        List<Bodega> bodegas = new ArrayList<Bodega>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String Pkid = rs.getString("Pkid");
                String tipo = rs.getString("tipo_bodega");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String estado = rs.getString("estado");
                
                bodega = new Bodega();
                bodega.setPkid(Pkid);
                bodega.setTipo_bodea(tipo);
                bodega.setNombre(nombre);
                bodega.setDireccion(direccion);
                bodega.setEstado(estado);
                
                bodegas.add(bodega);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return bodegas;
    }

    public int insert(Bodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bodega.getPkid());
            stmt.setString(2, bodega.getTipo_bodea());
            stmt.setString(3, bodega.getNombre());
            stmt.setString(4, bodega.getDireccion());
            stmt.setString(5, bodega.getEstado());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Bodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, bodega.getPkid());
            stmt.setString(2, bodega.getTipo_bodea());
            stmt.setString(3, bodega.getNombre());
            stmt.setString(4, bodega.getDireccion());
            stmt.setString(5, bodega.getEstado());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Bodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, bodega.getPkid());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Bodega query(Bodega bodega) {    
            Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query:" + SQL_QUERY);
        stmt = conn.prepareStatement(SQL_QUERY);
        stmt.setString(1, bodega.getPkid());
        rs = stmt.executeQuery();
        
        // Verificar si se encontraron resultados
        if (rs.next()) {
            String tipo = rs.getString("tipo_bodega");
            String nombre = rs.getString("nombre");
            String direccion = rs.getString("direccion");
            String estado = rs.getString("estado");
            
            // Actualizar los valores de la bodega proporcionada
            bodega.setTipo_bodea(tipo);
            bodega.setNombre(nombre);
            bodega.setDireccion(direccion);
            bodega.setEstado(estado);
        } else {
            // No se encontraron resultados, podrías devolver null o manejarlo de otra manera
            bodega = null;
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return bodega;
}
        
}
    

