package Modelo.vo;

/**
 *
 * @author Administrador
 */
public class FacturaProducto {
 public int getIdproducto() {
        return idproducto;
    }

    /**
     * @param idproducto the idproducto to set
     */
    public void setIdproducto(int idproducto) {
        this.idproducto=idproducto;
    }

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
        this.codfactura= codfactura;
    }

    /**
     * @return the cantidadtotal
     */
    public int getCantidadtotal() {
        return cantidadtotal;
    }

    /**
     * @param cantidadtotal the cantidadtotal to set
     */
    public void setCantidadtotal(int cantidadtotal) {
        this.cantidadtotal = cantidadtotal;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the idfacturaproducto
     */
    public int getIdfacturaproducto() {
        return idfacturaproducto;
    }

    /**
     * @param idfacturaproducto the idfacturaproducto to set
     */
    public void setIdfacturaproducto(int idfacturaproducto) {
        this.idfacturaproducto = idfacturaproducto;
    }
    private int idproducto;
    private int codfactura;
    private int cantidadtotal;
    private double subtotal;
    private int idfacturaproducto;
}  // Fin Clase FacturaProducto
