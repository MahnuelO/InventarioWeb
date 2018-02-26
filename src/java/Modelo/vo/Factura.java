package Modelo.vo;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Factura {
 private int codfactura;
    private Date fechafactura;
    private String tipofactura;
    private int valorunitario;
    private int valortotal;
    private Double descuento;
    private String detalles;
    private int idempleado;
    private Double devolucion;

    /**
     * @return the codfactura
     */
    public int getCodfactura() {
        return codfactura;
    }

    /**
     * @param codfactura the codfactura to set
     */
    public void setCodfactura(int codfactura) {
        this.codfactura = codfactura;
    }

    /**
     * @return the fechafactura
     */
    public Date getFechafactura() {
        return fechafactura;
    }

    /**
     * @param fechafactura the fechafactura to set
     */
    public void setFechafactura(Date fechafactura) {
        this.fechafactura = fechafactura;
    }

    /**
     * @return the tipofactura
     */
    public String getTipofactura() {
        return tipofactura;
    }

    /**
     * @param tipofactura the tipofactura to set
     */
    public void setTipofactura(String tipofactura) {
        this.tipofactura = tipofactura;
    }

    /**
     * @return the valorunitario
     */
    public int getValorunitario() {
        return valorunitario;
    }

    /**
     * @param valorunitario the valorunitario to set
     */
    public void setValorunitario(int valorunitario) {
        this.valorunitario = valorunitario;
    }

    /**
     * @return the valortotal
     */
    public int getValortotal() {
        return valortotal;
    }

    /**
     * @param valortotal the valortotal to set
     */
    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    /**
     * @return the descuento
     */
    public Double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the detalles
     */
    public String getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    /**
     * @return the devolucion
     */
    public Double getDevolucion() {
        return devolucion;
    }

    /**
     * @param devolucion the devolucion to set
     */
    public void setDevolucion(Double devolucion) {
        this.devolucion = devolucion;
    }

    /**
     * @return the idempleado
     */
    public int getIdempleado() {
        return idempleado;
    }

    /**
     * @param idempleado the idempleado to set
     */
    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }
    public String toString() {
        System.out.println(codfactura+ " "+ fechafactura);
        return this.codfactura+ "" +fechafactura;
    }
}  // Fin Clase Factura
