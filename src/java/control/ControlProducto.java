package control;
import Modelo.dao.ProductoDAO;
import Modelo.vo.Producto;
import Modelo.vo.Usuario;
import Modelo.vo.Producto;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import utils.AppException;
import java.util.List;
/*
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
    
  public void insertar(Producto vo) throws AppException{
        try {
            if(vo.getNombre().isEmpty()){
                throw new AppException("Campo Nombre incompleto");
            }
            if(dao.queryNombre(vo.getNombre()) != null){
                throw new AppException("Producto ya existe");
            }
            dao.insertar(vo);
        } catch (Exception e) {
            throw new AppException(e);
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
    public List<Producto> consultar(){
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
     public Producto consultarIdproducto(int idproducto) throws ParseException{
        try {
            return dao.consultaridProducto(idproducto);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}  // Fin Clase ControlProducto
