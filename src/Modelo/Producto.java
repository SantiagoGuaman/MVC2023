/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Producto {
    private int idproducto;
    private String nombre_pro;
    private double precio_pro;
    private int cantidad_pro;
    private String descripcion_pro;
    private byte foto_pro;

    public Producto() {
    }

    public Producto(int idproducto, String nombre_pro, double precio_pro, int cantidad_pro, String descripcion_pro, byte foto_pro) {
        this.idproducto = idproducto;
        this.nombre_pro = nombre_pro;
        this.precio_pro = precio_pro;
        this.cantidad_pro = cantidad_pro;
        this.descripcion_pro = descripcion_pro;
        this.foto_pro = foto_pro;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public double getPrecio_pro() {
        return precio_pro;
    }

    public void setPrecio_pro(double precio_pro) {
        this.precio_pro = precio_pro;
    }

    public int getCantidad_pro() {
        return cantidad_pro;
    }

    public void setCantidad_pro(int cantidad_pro) {
        this.cantidad_pro = cantidad_pro;
    }

    public String getDescripcion_pro() {
        return descripcion_pro;
    }

    public void setDescripcion_pro(String descripcion_pro) {
        this.descripcion_pro = descripcion_pro;
    }

    public byte getFoto_pro() {
        return foto_pro;
    }

    public void setFoto_pro(byte foto_pro) {
        this.foto_pro = foto_pro;
    }
}
