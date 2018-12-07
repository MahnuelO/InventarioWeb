package Modelo.vo;

/**
 *
 * @author Administrador
 */
public class FacturaProducto {
   private int idproducto;
    private int codfactura;
    private int cantidadtotal;
    private double subtotal;
    private int idfacturaproducto;
    
    public int getIdproducto() {
        return idproducto;
    }

    
    public void setIdproducto(int idproducto) {
        this.idproducto=idproducto;
    }

   
    public int getCodfactura() {
        return codfactura;
    }

    
    public void setCodfactura(int codfactura) {
        this.codfactura= codfactura;
    }

  
    public int getCantidadtotal() {
        return cantidadtotal;
    }

    public void setCantidadtotal(int cantidadtotal) {
        this.cantidadtotal = cantidadtotal;
    }

   
    public double getSubtotal() {
        return subtotal;
    }

    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

   
    public int getIdfacturaproducto() {
        return idfacturaproducto;
    }

    
    public void setIdfacturaproducto(int idfacturaproducto) {
        this.idfacturaproducto = idfacturaproducto;
    }
  
}  
