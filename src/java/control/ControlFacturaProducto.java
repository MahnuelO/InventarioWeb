package control;
import Modelo.dao.FacturaProductoDAO;
import Modelo.vo.FacturaProducto;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import utils.AppException;

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
    
     public void insertar(FacturaProducto vo) throws AppException{
        try {
            if(!Integer.toString(vo.getCantidadtotal()).isEmpty()){
            } else {
                throw new AppException("Campo cantidad total incompleto");
            }
            if(dao.queryNombre(vo.getCantidadtotal()) != null){
                throw new AppException("Detalle Factura ya existe");
            }
            dao.insertar(vo);
        } catch (Exception e) {
            throw new AppException(e);
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
     
   public List<FacturaProducto> consultar(){
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
     public FacturaProducto consultarIdFacturaProducto(int idfacturaproducto) throws ParseException{
        try {
            return dao.consultaridFacturaProducto(idfacturaproducto);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}  // Fin Clase ControlFacturaProducto
