/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Leticia
 */
public class Bodega {

    private String Pkid;
    private String tipo_bodea;
    private String nombre;
    private String direccion;
    private String estado;
    
    public Bodega(String Pkid, String tipo_bodea, String nombre, String direccion, String estado) {
        this.Pkid = Pkid;
        this.tipo_bodea = tipo_bodea;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getPkid() {
        return Pkid;
    }

    public void setPkid(String Pkid) {
        this.Pkid = Pkid;
    }

    public String getTipo_bodea() {
        return tipo_bodea;
    }

    public void setTipo_bodea(String tipo_bodea) {
        this.tipo_bodea = tipo_bodea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
  
}
