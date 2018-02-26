package Modelo.dao;
import Modelo.vo.Empleado;
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
public class EmpleadoDAO {
Connection cnn;
    
    
    public EmpleadoDAO (Connection cnn){
     this.cnn = cnn;
    }
    
    
    public void insertar(Empleado vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                        "INSERT INTO empleado (nombre,apellido,celular,direccion,correo,cargo) "
                + "VALUES(?,?,?,?,?,?)");
        sentencia.setString(1, vo.getNombre());
        sentencia.setString(2, vo.getApellido());
        sentencia.setString(3, vo.getCelular());
        sentencia.setString(4, vo.getDireccion());
        sentencia.setString(5, vo.getCorreo());
        sentencia.setString(6, vo.getCargo());
        sentencia.executeUpdate();
    }
    
//    public void borrar(Empleado vo) throws SQLException{
//        PreparedStatement sentencia = 
//                cnn.prepareStatement(
//                        "DELETE empleado "
//                + "WHERE idempleado = ?");
//        sentencia.setInt(1, vo.getIdempleado());
//        sentencia.executeUpdate();
//    }
//    
    public void modificar(Empleado vo) throws SQLException{
        PreparedStatement sentencia = 
              cnn.prepareStatement(
                        "UPDATE empleado SET nombre= ?,apellido= ?,celular= ?,direccion=?,correo= ?,cargo= ? "
                + "WHERE idempleado = ?");
       sentencia.setString(1, vo.getNombre());
       sentencia.setString(2, vo.getApellido());
        sentencia.setString(3, vo.getCelular());
        sentencia.setString(4, vo.getDireccion());
       sentencia.setString(4, vo.getCorreo());
       sentencia.setString(5, vo.getCargo());
       sentencia.setInt(6, vo.getIdempleado());
       sentencia.executeUpdate();
    }
    
    public List<Empleado> consultar() throws SQLException{
        List<Empleado> listaEmpleado = new ArrayList<>();
        
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM empleado");
        ResultSet resultado =  sentencia.executeQuery();
        while (resultado.next()) {
            Empleado voTemp = new Empleado();
            voTemp.setIdempleado(resultado.getInt("idempleado"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setApellido(resultado.getString("apellido"));
            voTemp.setCelular(resultado.getString("celular"));
            voTemp.setDireccion(resultado.getString("direccion"));
            voTemp.setCorreo(resultado.getString("correo"));
            voTemp.setCargo(resultado.getString("cargo"));
            listaEmpleado.add(voTemp);
        }
        if(listaEmpleado.size() > 0){
            return listaEmpleado;
        }else{
            return null;
        }
    }
        
       

//    public void modificar(Empleado vo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public List<Empleado> consultarnombre(String nombre) throws SQLException {
        List<Empleado> listaEmpleado = new ArrayList<>();
        
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM empleado");
        ResultSet resultado =  sentencia.executeQuery();
        while (resultado.next()) {
            Empleado voTemp = new Empleado();
            voTemp.setIdempleado(resultado.getInt("idempleado"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setApellido(resultado.getString("apellido"));
            voTemp.setCelular(resultado.getString("celular"));
             voTemp.setDireccion(resultado.getString("direccion"));
            voTemp.setCorreo(resultado.getString("correo"));
            voTemp.setCargo(resultado.getString("cargo"));
            
            listaEmpleado.add(voTemp);
        }
        if(listaEmpleado.size() > 0){
            return listaEmpleado;
        }else{
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }
}  // Fin Clase EmpleadoDAO
