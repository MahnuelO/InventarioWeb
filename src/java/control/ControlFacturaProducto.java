package control;
import Modelo.dao.FacturaProductoDAO;
import Modelo.vo.FacturaProducto;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class ControlFacturaProducto {
 Connection cnn;
    FacturaProductoDAO dao;
    
    public ControlFacturaProducto(Connection cnn){
        this.cnn = cnn;
        this.dao = new FacturaProductoDAO(cnn);
    }
    
    public boolean insertar(FacturaProducto vo){
        if(vo.getSubtotal()!= 0 
                || vo.getSubtotal()==0
                || vo.getCantidadtotal()!=0 
                || vo.getCantidadtotal()==0){
               
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
    
     public boolean modificar(FacturaProducto vo){
        if(vo.getCantidadtotal()!= 0 || vo.getCantidadtotal()==0
                || vo.getSubtotal()!= 0 || vo.getSubtotal()==0
                || vo.getIdfacturaproducto()== 0){
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
}  // Fin Clase ControlFacturaProducto
