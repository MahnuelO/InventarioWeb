package Modelo.dao;
import Modelo.vo.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class FacturaDAO {
Connection cnn;
    
    
    public FacturaDAO (Connection cnn){
     this.cnn = cnn;
    }
    
    
    public void insertar(Factura vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                        "INSERT INTO factura (fechafactura,tipofactura,valorunitario,valortotal,descuento,detalles,idempleado,devolucion) "
                + "VALUES(?,?,?,?,?,?,?,?)");
        sentencia.setDate(1, new java.sql.Date(vo.getFechafactura().getTime()));
        sentencia.setString(2, vo.getTipofactura());
        sentencia.setInt(3, vo.getValorunitario());
        sentencia.setInt(4, vo.getValortotal());
        sentencia.setDouble(5, vo.getDescuento());
        sentencia.setString(6, vo.getDetalles());
        sentencia.setInt(7, vo.getIdempleado());
         sentencia.setDouble(8, vo.getDevolucion());
        sentencia.executeUpdate();
    }
    
    public void borrar(Factura vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                        "DELETE factura "
                + "WHERE idcontacto = ?");
        sentencia.setInt(1, vo.getCodfactura());
        sentencia.executeUpdate();
    }
    
    public void modificar(Factura vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                        "UPDATE factura SET fechafactura= ?,tipofactura= ?,valorunitario= ?,valortotal=?,descuento= ?,detalles= ?,idempleado=?,devolucion=? "
                + "WHERE codfactura = ?");
        sentencia.setDate(1, new java.sql.Date(vo.getFechafactura().getTime()));
        sentencia.setString(2, vo.getTipofactura());
        sentencia.setInt(3, vo.getValorunitario());
        sentencia.setInt(4, vo.getValortotal());
        sentencia.setDouble(5, vo.getDescuento());
        sentencia.setString(6, vo.getDetalles());
        sentencia.setInt(7, vo.getIdempleado());
         sentencia.setDouble(8, vo.getDevolucion());
         sentencia.setInt(9, vo.getCodfactura());
        sentencia.executeUpdate();
    }
    
    public List<Factura> consultar() throws SQLException{
        List<Factura> listaFactura = new ArrayList<>();
        
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM factura");
        ResultSet resultado =  sentencia.executeQuery();
        while (resultado.next()) {
            Factura voTemp = new Factura();
            voTemp.setFechafactura(resultado.getDate("fechafactura"));
            voTemp.setTipofactura(resultado.getString("tipofactura"));
            voTemp.setValorunitario(resultado.getInt("valorunitario"));
            voTemp.setValortotal(resultado.getInt("valortotal"));
            voTemp.setDescuento(resultado.getDouble("descuento"));
            voTemp.setDetalles(resultado.getString("detales"));
            voTemp.setDevolucion(resultado.getDouble("devolucion"));
            listaFactura.add(voTemp);
        }
        if(listaFactura.size() > 0){
            return listaFactura;
        }else{
            return null;
        }
        
        
    }
         public List<Factura> consultarf() throws SQLException{
        List<Factura> listaFactura = new ArrayList<>();
        
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM factura");
        ResultSet resultado =  sentencia.executeQuery();
        while (resultado.next()) {
            Factura voTemp = new Factura();
            voTemp.setCodfactura(resultado.getInt("codfactura"));
            voTemp.setFechafactura(resultado.getDate("fechafactura"));
            listaFactura.add(voTemp);
        }
        if(listaFactura.size() > 0){
            return listaFactura;
        }else{
            return null;
        }
        }
}  // Fin Clase FacturaDAO
