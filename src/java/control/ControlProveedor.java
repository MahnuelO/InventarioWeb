package control;
import Modelo.dao.ProveedorDAO;
import Modelo.vo.Usuario;
import Modelo.vo.Proveedor;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import utils.AppException;

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
    
    
    public void insertar(Proveedor vo) throws AppException{
        try {
            if(vo.getNombre().isEmpty()){
                throw new AppException("Campo Nombre incompleto");
            }
            if(dao.queryNombre(vo.getNombre()) != null){
                throw new AppException("Proveedor ya existe");
            }
            dao.insertar(vo);
        } catch (Exception e) {
            throw new AppException(e);
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
   
   
     
    public List<Proveedor> consultar(){
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
     public Proveedor consultarIdproveedor(int idproveedor) throws ParseException{
        try {
            return dao.consultaridProveedor(idproveedor);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}  // Fin Clase ControlProveedor
