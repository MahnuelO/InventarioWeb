package control;
import Modelo.dao.ProductoDAO;
import Modelo.vo.Producto;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class ControlProducto {
 Connection cnn;
    ProductoDAO dao;
    
    public ControlProducto(Connection cnn){
        this.cnn = cnn;
        this.dao = new ProductoDAO(cnn);
    }
    
    public boolean insertar(Producto vo){
        if(vo.getNombre()== null 
                || vo.getNombre().isEmpty()
                || vo.getTipop()== null 
                || vo.getTipop().isEmpty()
                || vo.getDescripcion()== null 
                || vo.getDescripcion().isEmpty()){
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
    
   public boolean modificar(Producto vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getTipop()== null || vo.getTipop().isEmpty()
                || vo.getDescripcion()== null || vo.getDescripcion().isEmpty()
                || vo.getIdproducto()== 0){
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
}  // Fin Clase ControlProducto
