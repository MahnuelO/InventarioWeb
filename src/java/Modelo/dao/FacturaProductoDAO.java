package Modelo.dao;
import Modelo.vo.FacturaProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class FacturaProductoDAO {
 Connection cnn;
    
    
    public FacturaProductoDAO (Connection cnn){
     this.cnn = cnn;
    }


//     public List<Producto> consultarp() throws SQLException{
//        List<Producto> listaProducto = new ArrayList<>();
//        
//        PreparedStatement sentencia = cnn.prepareStatement("SELECT idproducto FROM producto");
//        ResultSet resultado =  sentencia.executeQuery();
//        while (resultado.next()) {
//            Producto voTemp = new Producto();
//            voTemp.setIdproducto(resultado.getInt("idproducto"));
//            listaProducto.add(voTemp);
//        }
//        if(listaProducto.size() > 0){
//            return listaProducto;
//        }else{
//            return null;
//        }
//        }
     
//     public List<Factura> consultarf() throws SQLException{
//        List<Factura> listaFactura = new ArrayList<>();
//        
//        PreparedStatement sentencia = cnn.prepareStatement("SELECT codfactura FROM factura");
//        ResultSet resultado =  sentencia.executeQuery();
//        while (resultado.next()) {
//            Factura voTemp = new Factura();
//            voTemp.setCodfactura(resultado.getInt("codfactura"));
//            listaFactura.add(voTemp);
//        }
//        if(listaFactura.size() > 0){
//            return listaFactura;
//        }else{
//            return null;
//        }
//        }
     
     
     
    public void insertar(FacturaProducto vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                        "INSERT INTO facturaproducto (idproducto,codfactura,cantidadtotal,subtotal)"
                + "VALUES(?,?,?,?)");
        sentencia.setInt(1, vo.getIdproducto());
        sentencia.setInt(2, vo.getCodfactura());
        sentencia.setInt(3, vo.getCantidadtotal());
        sentencia.setDouble(4, vo.getSubtotal());
        sentencia.executeUpdate();
    }
     public void modificar(FacturaProducto vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                        "UPDATE facturaproducto SET idproducto= ?,codfactura= ?,cantidadtotal= ?,subtotal=?"
                + "WHERE idfacturaproducto = ?");
       
        sentencia.setInt(1, vo.getIdproducto());
        sentencia.setInt(2, vo.getCodfactura());
        sentencia.setInt(3, vo.getCantidadtotal());
        sentencia.setDouble(4, vo.getSubtotal());
        sentencia.setDouble(5, vo.getIdfacturaproducto());
        
        sentencia.executeUpdate();
    }
}  // Fin Clase FacturaProductoDAO
