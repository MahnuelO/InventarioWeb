package Modelo.dao;
import Modelo.vo.FacturaProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class FacturaProductoDAO {
 Connection cnn;
    
    
    public FacturaProductoDAO (Connection cnn){
     this.cnn = cnn;
    }
public void insertar(FacturaProducto vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                        "INSERT INTO factura_producto (idproducto,codfactura,cantidatotal,subtotal)"
                + "VALUES(?,?,?,?)");
        sentencia.setInt(1, vo.getIdproducto());
        sentencia.setInt(2, vo.getCodfactura());
        sentencia.setInt(3, vo.getCantidadtotal());
        sentencia.setDouble(4, vo.getSubtotal());
        sentencia.executeUpdate();
    }

    public List<FacturaProducto> consultar() throws SQLException{
        List<FacturaProducto> listaFacturaproducto = new ArrayList<>();
        
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM factura_producto");
        ResultSet resultado =  sentencia.executeQuery();
        while (resultado.next()) {
            FacturaProducto voTemp = new FacturaProducto();
            voTemp.setIdproducto(resultado.getInt("idproducto"));
            voTemp.setCodfactura(resultado.getInt("codfactura"));
            voTemp.setCantidadtotal(resultado.getInt("cantidatotal"));
            voTemp.setSubtotal(resultado.getDouble("subtotal"));
            voTemp.setIdfacturaproducto(resultado.getInt("idfacturaproducto"));
            
            listaFacturaproducto.add(voTemp);
        }
        if(listaFacturaproducto.size() > 0){
            return listaFacturaproducto;
        }else{
            return null;
        }  
    }
  
     public void modificar(FacturaProducto vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                        "UPDATE factura_producto SET idproducto= ?,codfactura= ?,cantidatotal= ?,subtotal=?"
                + "WHERE idfacturaproducto = ?");
       
        sentencia.setInt(1, vo.getIdproducto());
        sentencia.setInt(2, vo.getCodfactura());
        sentencia.setInt(3, vo.getCantidadtotal());
        sentencia.setDouble(4, vo.getSubtotal());
        sentencia.setDouble(5, vo.getIdfacturaproducto());
        
        sentencia.executeUpdate();
    }

//     public List<FacturaProducto> consultar() throws SQLException{
//        List<FacturaProducto> listaProducto = new ArrayList<>();
//        
//        PreparedStatement sentencia = cnn.prepareStatement("SELECT idfacturaproducto FROM factura_producto");
//        ResultSet resultado =  sentencia.executeQuery();
//        while (resultado.next()) {
//            FacturaProducto voTemp = new FacturaProducto();
//            voTemp.setIdfacturaproducto(resultado.getInt("idfacturaproducto"));
//            listaProducto.add(voTemp);
//        }
//        if(listaProducto.size() > 0){
//            return listaProducto;
//        }else{
//            return null;
//        }
//        }
    
       public List<FacturaProducto> consultarnombre(String nombre) throws SQLException {
        List<FacturaProducto> listaEmpleado = new ArrayList<>();

        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM factura_producto");
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            FacturaProducto voTemp = new FacturaProducto();
           voTemp.setCantidadtotal(resultado.getInt("cantidatotal"));
            voTemp.setSubtotal(resultado.getDouble("subtotal"));
            listaEmpleado.add(voTemp);
        }
        if (listaEmpleado.size() > 0) {
            return listaEmpleado;
        } else {
            return null;
        } 
    }

    public FacturaProducto queryNombre(int cantidadtotal) throws SQLException, ParseException {
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM factura_producto WHERE cantidatotal=?");
        sentencia.setString(1, Integer.toString(cantidadtotal));
        ResultSet resultado = sentencia.executeQuery();
        if (resultado.next()) {
            return getVo(resultado);
        }
        return null;
    }
     public FacturaProducto consultaridFacturaProducto(int idfacturaproducto) throws SQLException, ParseException {
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM factura_producto WHERE idfacturaproducto=?");
        sentencia.setInt(1, idfacturaproducto);
        ResultSet resultado = sentencia.executeQuery();
        if (resultado.next()) {
            return getVo(resultado);
        }
        return null;
    }

    public FacturaProducto getVo(ResultSet resultado) throws SQLException, ParseException {
        FacturaProducto vot = new FacturaProducto();
    
            vot.setCantidadtotal(resultado.getInt("cantidadtotal"));
            vot.setSubtotal(resultado.getDouble("subtotal"));
           
        return vot;
    }
     
     
     
    
}  // Fin Clase FacturaProductoDAO
