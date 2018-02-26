package control;
import Modelo.dao.FacturaDAO;
import Modelo.vo.Factura;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class ControlFactura {
  Connection cnn;
    FacturaDAO dao;
    
    public ControlFactura(Connection cnn){
        this.cnn = cnn;
        this.dao = new FacturaDAO(cnn);
    }
    
    public boolean insertar(Factura vo){
        if(vo.getTipofactura()== null 
                || vo.getTipofactura().isEmpty()
                || vo.getDetalles()== null 
                || vo.getDetalles().isEmpty()){
               
            return false;
        }else{
            try {
                dao.insertar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        
    }
     public boolean modificar(Factura vo){
        if(vo.getTipofactura()== null || vo.getTipofactura().isEmpty()
                || vo.getDetalles()== null || vo.getDetalles().isEmpty()
                || vo.getCodfactura()== 0){
            return false;
        }else{
            try {
                dao.modificar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        
    }

//    public boolean insertar(Factura vo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public boolean modificar(Factura vo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}  // Fin Clase ControlFactura
