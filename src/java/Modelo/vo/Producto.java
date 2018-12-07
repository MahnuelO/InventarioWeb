package Modelo.vo;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Producto {
 private int idproducto;
    private String nombre;
    private int cantidadp;
    private String tipop;
    private int preciop;
    private Date fecharegistro;
    private String descripcion;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadp() {
        return cantidadp;
    }

    public void setCantidadp(int cantidadp) {
        this.cantidadp = cantidadp;
    }

    public String getTipop() {
        return tipop;
    }

    public void setTipop(String tipop) {
        this.tipop = tipop;
    }

    public int getPreciop() {
        return preciop;
    }

    public void setPreciop(int preciop) {
        this.preciop = preciop;
    }

  
    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        System.out.println(idproducto+ " "+ nombre);
        return this.idproducto+ "" +nombre;
    }
//    
}  // Fin Clase Producto
