package control;
import Modelo.dao.ProveedorDAO;
import Modelo.vo.Proveedor;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class ControlProveedor {
 Connection cnn;
    ProveedorDAO dao;
    
    
    public ControlProveedor(Connection cnn){
        this.cnn = cnn;
        this.dao = new ProveedorDAO(cnn);
    }
    
    public boolean insertar(Proveedor vo){
        if(vo.getNombre()== null 
                || vo.getNombre().isEmpty()
                || vo.getApellido()== null 
                || vo.getCelular().isEmpty()
                || vo.getCorreo()== null 
                || vo.getEmpresa().isEmpty()){
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
    
   public boolean modificar(Proveedor vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getApellido()== null || vo.getApellido().isEmpty()
                || vo.getCelular()== null || vo.getCelular().isEmpty()
                || vo.getIdproveedor()== 0){
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
}  // Fin Clase ControlProveedor
