package Modelo.dao;
import Modelo.vo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class ProveedorDAO {
 Connection cnn;
    
    
    public ProveedorDAO (Connection cnn){
     this.cnn = cnn;
    }
    
    
    public void insertar(Proveedor vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
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
//    public List<Proveedor> consultar() throws SQLException{
//        List<Proveedor> listaProveedor = new ArrayList<>();
//        
//        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM proveedor");
//        ResultSet resultado =  sentencia.executeQuery();
//        while (resultado.next()) {
//            Proveedor voTemp = new Proveedor();
//            voTemp.setIdproveedor(resultado.getInt("idproveedor"));
//            voTemp.setNombre(resultado.getString("nombre"));
//            voTemp.setApellido(resultado.getString("apellido"));
//            voTemp.setCorreo(resultado.getString("correo"));
//            voTemp.setEmpresa(resultado.getString("empresa"));
//            voTemp.setDireccionempresa(resultado.getString("direccionempresa"));
//            voTemp.setFecharegistro(resultado.getDate("fecharegistro"));
//            listaProveedor.add(voTemp);
//        }
//        if(listaProveedor.size() > 0){
//            return listaProveedor;
//        }else{
//            return null;
//        }
//        
//    }

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
