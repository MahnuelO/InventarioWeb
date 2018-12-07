package Modelo.dao;

import Modelo.vo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Administrador
 */
public class ProductoDAO {

    Connection cnn;

    public ProductoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public void insertar(Producto vo) throws SQLException {
        PreparedStatement sentencia
                = cnn.prepareStatement(
                        "INSERT INTO producto (nombre,cantidadp,tipop,preciop,fecharegistro,descripcion) "
                        + "VALUES(?,?,?,?,?,?)");
        sentencia.setString(1, vo.getNombre());
        sentencia.setInt(2, vo.getCantidadp());
        sentencia.setString(3, vo.getTipop());
        sentencia.setInt(4, vo.getPreciop());
        sentencia.setDate(5, new java.sql.Date(vo.getFecharegistro().getTime()));
        sentencia.setString(6, vo.getDescripcion());

        sentencia.executeUpdate();
    }

//    public void borrar(Producto vo) throws SQLException{
//        PreparedStatement sentencia = 
//                cnn.prepareStatement(
//                        "DELETE producto "
//                + "WHERE idproducto = ?");
//        sentencia.setInt(1, vo.getIdproducto());
//        sentencia.executeUpdate();
//    }
    public void modificar(Producto vo) throws SQLException {
        PreparedStatement sentencia
                = cnn.prepareStatement(
                        "UPDATE producto SET nombre= ?,cantidadp= ?,tipop= ?,preciop=?,fecharegistro= ?,descripcion= ? "
                        + "WHERE idproducto = ?");
        sentencia.setString(1, vo.getNombre());
        sentencia.setInt(2, vo.getCantidadp());
        sentencia.setString(3, vo.getTipop());
        sentencia.setInt(4, vo.getPreciop());
        sentencia.setDate(5, new java.sql.Date(vo.getFecharegistro().getTime()));
        sentencia.setString(6, vo.getDescripcion());
        sentencia.setInt(7, vo.getIdproducto());

        sentencia.executeUpdate();
    }

    public List<Producto> consultar() throws SQLException {
        List<Producto> listaProducto = new ArrayList<>();

        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM producto");
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Producto voTemp = new Producto();
            voTemp.setIdproducto(resultado.getInt("idproducto"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setCantidadp(resultado.getInt("cantidadp"));
            voTemp.setTipop(resultado.getString("tipop"));
            voTemp.setPreciop(resultado.getInt("preciop"));
            voTemp.setFecharegistro(resultado.getDate("fecharegistro"));
            voTemp.setDescripcion(resultado.getString("descripcion"));
            listaProducto.add(voTemp);
        }
        if (listaProducto.size() > 0) {
            return listaProducto;
        } else {
            return null;
        }

    }

    public List<Producto> consultarnombre(String nombre) throws SQLException {
        List<Producto> listaProveedor = new ArrayList<>();

        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM producto");
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
//            try {
            Producto voTemp = new Producto();
            voTemp.setIdproducto(resultado.getInt("idproveedor"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setCantidadp(resultado.getInt("cantidadp"));
            voTemp.setTipop(resultado.getString("tipop"));
            voTemp.setPreciop(resultado.getInt("preciop"));
            voTemp.setFecharegistro(resultado.getDate("fecharegistro"));
            voTemp.setDescripcion(resultado.getString("descripcion"));

            listaProveedor.add(voTemp);
//            } catch (ParseException ex) {
//                ex.printStackTrace();
//            }
        }
        if (listaProveedor.size() > 0) {
            return listaProveedor;
        } else {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    public Producto queryNombre(String nombre) throws SQLException, ParseException {
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM producto WHERE nombre=?");
        sentencia.setString(1, nombre);
        ResultSet resultado = sentencia.executeQuery();
        if (resultado.next()) {
            return getVo(resultado);
        }
        return null;
    }

    public Producto consultaridProducto(int idproducto) throws SQLException, ParseException {
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM producto WHERE idproducto=?");
        sentencia.setInt(1, idproducto);
        ResultSet resultado = sentencia.executeQuery();
        if (resultado.next()) {
            return getVo(resultado);
        }
        return null;
    }
    
    public Producto getVo(ResultSet resultado) throws SQLException, ParseException {

        Producto vot = new Producto();
        vot.setIdproducto(resultado.getInt("idproveedor"));
        vot.setNombre(resultado.getString("nombre"));
        vot.setCantidadp(resultado.getInt("cantidadp"));
        vot.setTipop(resultado.getString("tipop"));
        vot.setPreciop(resultado.getInt("preciop"));
        vot.setDescripcion(resultado.getString("descripcion"));
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
         vot.setFecharegistro(formato.parse(resultado.getString("fecharegistro")));
        return vot;

    }
//    public List<Producto> consultarp() throws SQLException{
//        List<Producto> listaProducto = new ArrayList<>();
//        
//        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM producto");
//        ResultSet resultado =  sentencia.executeQuery();
//        while (resultado.next()) {
//            Producto voTemp = new Producto();
//            voTemp.setIdproducto(resultado.getInt("idproducto"));
//            voTemp.setNombre(resultado.getString("nombre"));
//            listaProducto.add(voTemp);
//        }
//        if(listaProducto.size() > 0){
//            return listaProducto;
//        }else{
//            return null;
//        }
//        }
}  // Fin Clase ProductoDAO
