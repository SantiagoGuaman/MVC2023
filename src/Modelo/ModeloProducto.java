/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloProducto extends Producto {

    public ModeloProducto() {
    }

    public ModeloProducto(int idproducto, String nombre_pro, double precio_pro, int cantidad_pro, String descripcion_pro, byte foto_pro) {
        super(idproducto, nombre_pro, precio_pro, cantidad_pro, descripcion_pro, foto_pro);
    }
    
    public List<Producto> ListProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT idproducto, nombre, precio, cantidad, descripcion from producto";
        ConectPG conpq = new ConectPG();
        ResultSet rs = conpq.Consulta(sql);
        try {            
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdproducto(rs.getInt(1));
                pro.setNombre_pro(rs.getString(2));
                pro.setPrecio_pro(rs.getDouble(3));
                pro.setCantidad_pro(rs.getInt(4));
                pro.setDescripcion_pro(rs.getString(5));

                lista.add(pro);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public SQLException GrabaProductoDB() {
        String sql = "INSERT INTO producto (idproducto, nombre, precio, cantidad, descripcion) "
                + "VALUES (" + getIdproducto() + ",'" + getNombre_pro() + "', " + getPrecio_pro() + ", "
                + "" + getCantidad_pro() + ", '" + getDescripcion_pro() + "')"; 
        
        ConectPG con = new ConectPG();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
    public int ObtieneID() {
        String sql = "SELECT max(idproducto) from producto";
        ConectPG con = new ConectPG();
        ResultSet rs = con.Consulta(sql);
        int id = 1;
        try {
            while (rs.next()) {                
               id = rs.getInt(1);
            }
            rs.close();
            return id;
        } catch (SQLException e) {
            System.out.println(e);
            return id;
        }
    }
    
    public List<Producto> BuscarProductoBD(String search) {
            List<Producto> lista = new ArrayList<>();
            String sql = "SELECT idproducto, nombre, precio, cantidad, descripcion "
                + "FROM producto WHERE nombre LIKE '%" + search + "%' OR descripcion LIKE '%" + search + "%'";
            ConectPG conpq = new ConectPG();
            ResultSet rs = conpq.Consulta(sql);
        try {            
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdproducto(rs.getInt(1));
                pro.setNombre_pro(rs.getString(2));
                pro.setPrecio_pro(rs.getDouble(3));
                pro.setCantidad_pro(rs.getInt(4));
                pro.setDescripcion_pro(rs.getString(5));

                lista.add(pro);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public SQLException ModficarProductoDB(int bus) {
        String sql = "UPDATE producto SET  nombre = '" + getNombre_pro() + "', precio = " + getPrecio_pro() + ", cantidad = " + getCantidad_pro()
                + ", descripcion = '" + getDescripcion_pro() + "'  WHERE idproducto = " + bus; 
        ConectPG con = new ConectPG();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
    public SQLException EliminarProductoDB(int id) {
        String sql = "DELETE FROM producto WHERE idproducto = " + id + "";
        
        ConectPG con = new ConectPG();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
}
