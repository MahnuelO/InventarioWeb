package control;
import Modelo.dao.FacturaDAO;
import Modelo.vo.Factura;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import utils.AppException;

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
    
    public void insertar(Factura vo) throws AppException{
        try {
            if(vo.getTipofactura().isEmpty()){
                throw new AppException("Campo Tipo Factura incompleto");
            }
            if(dao.queryNombre(vo.getTipofactura()) != null){
                throw new AppException("Factura ya existe");
            }
            dao.insertar(vo);
        } catch (Exception e) {
            throw new AppException(e);
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

public List<Factura> consultar(){
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}  // Fin Clase ControlFactura
