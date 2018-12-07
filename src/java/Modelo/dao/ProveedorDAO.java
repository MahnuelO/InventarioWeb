package Modelo.dao;

import Modelo.vo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ProveedorDAO {

    Connection cnn;

    public ProveedorDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public void insertar(Proveedor vo) throws SQLException {
        PreparedStatement sentencia
                = cnn.prepareStatement(
                        "INSERT INTO proveedor (nombre,apellido,celular,correo,empresa,direccionempresa,fecharegistro) "
                        + "VALUES(?,?,?,?,?,?,?)");
        sentencia.setString(1, vo.getNombre());
        sentencia.setString(2, vo.getApellido());
        sentencia.setString(3, vo.getCelular());
        sentencia.setString(4, vo.getCorreo());
        sentencia.setString(5, vo.getEmpresa());
        sentencia.setString(6, vo.getDireccionempresa());
        sentencia.setDate(7, new java.sql.Date(vo.getFecharegistro().getTime()));
        sentencia.executeUpdate();
    }

    public List<Proveedor> consultar() throws SQLException {
        List<Proveedor> listaProveedor = new ArrayList<>();

        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM proveedor");
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {

            Proveedor voTemp = new Proveedor();

            voTemp.setIdproveedor(resultado.getInt("idproveedor"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setApellido(resultado.getString("apellido"));
            voTemp.setCelular(resultado.getString("celular"));
            voTemp.setCorreo(resultado.getString("correo"));
            voTemp.setEmpresa(resultado.getString("empresa"));
            voTemp.setDireccionempresa(resultado.getString("direccionempresa"));
            voTemp.setFecharegistro(resultado.getDate("fecharegistro"));

            listaProveedor.add(voTemp);

        }
        if (listaProveedor.size() > 0) {
            return listaProveedor;
        } else {
            return null;
        }
    }

//    public void borrar(Empleado vo) throws SQLException{
//        PreparedStatement sentencia = 
//                cnn.prepareStatement(
//                        "DELETE proveedor "
//                + "WHERE idproveedor = ?");
//        sentencia.setInt(1, vo.getIdempleado());
//        sentencia.executeUpdate();
//    }
//    
//    public void modificar(Proveedor vo) throws SQLException{
//    }
//    
//   
    public List<Proveedor> consultarnombre(String nombre) throws SQLException {
        List<Proveedor> listaProveedor = new ArrayList<>();

        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM proveedor");
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
//            try {
            Proveedor voTemp = new Proveedor();
            voTemp.setIdproveedor(resultado.getInt("idproveedor"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setApellido(resultado.getString("apellido"));
            voTemp.setCelular(resultado.getString("celular"));
            voTemp.setCorreo(resultado.getString("correo"));
            voTemp.setEmpresa(resultado.getString("empresa"));
            voTemp.setDireccionempresa(resultado.getString("direccionempresa"));
            voTemp.setFecharegistro(resultado.getDate("fecharegistro"));

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

    public Proveedor queryNombre(String nombre) throws SQLException, ParseException {
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM proveedor WHERE nombre=?");
        sentencia.setString(1, nombre);
        ResultSet resultado = sentencia.executeQuery();
        if (resultado.next()) {
            return getVo(resultado);
        }
        return null;
    }
  public Proveedor consultaridProveedor(int idproveedor) throws SQLException, ParseException {
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM proveedor WHERE idproveedor=?");
        sentencia.setInt(1, idproveedor);
        ResultSet resultado = sentencia.executeQuery();
        if (resultado.next()) {
            return getVo(resultado);
        }
        return null;
    }
    public Proveedor getVo(ResultSet resultado) throws SQLException, ParseException {

        Proveedor vot = new Proveedor();
        vot.setIdproveedor(resultado.getInt("idproveedor"));
        vot.setNombre(resultado.getString("nombre"));
        vot.setApellido(resultado.getString("apellido"));
        vot.setCelular(resultado.getString("celular"));
        vot.setEmpresa(resultado.getString("empresa"));
        vot.setDireccionempresa(resultado.getString("direccionempresa"));
        vot.setCorreo(resultado.getString("correo"));
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
         vot.setFecharegistro(formato.parse(resultado.getString("fecharegistro")));
        return vot;

    }

    public void modificar(Proveedor vo) throws SQLException {
                PreparedStatement sentencia = 
                cnn.prepareStatement(
                        "UPDATE proveedor SET nombre= ?,apellido= ?,celular= ?,correo= ?,empresa= ?,direccionempresa=?,fecharegistro=? "
                + "WHERE idproveedor = ?");
        sentencia.setString(1, vo.getNombre());
        sentencia.setString(2, vo.getApellido());
        sentencia.setString(3, vo.getCelular());
        sentencia.setString(4, vo.getCorreo());
        sentencia.setString(5, vo.getEmpresa());
        sentencia.setString(6, vo.getDireccionempresa());
         sentencia.setDate(7, new java.sql.Date(vo.getFecharegistro().getTime()));
         sentencia.setInt(8, vo.getIdproveedor());
        sentencia.executeUpdate();
    }
}  // Fin Clase ProveedorDAO
