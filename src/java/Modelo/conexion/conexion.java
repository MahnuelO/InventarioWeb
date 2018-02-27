package Modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class conexion {
 public static Connection getConexionDB() throws ClassNotFoundException, SQLException{
        String servidor = "localhost";
        String nombreDB = "inventario";
        String usuario = "carmen";
        String clave = "12345";
        String puerto = "3306";
        
        Class.forName("com.mysql.jdbc.Driver"); 
        
        Connection cnn = DriverManager.getConnection("jdbc:mysql://"+servidor+":"+puerto+"/"+nombreDB, usuario, clave);
        cnn.setAutoCommit(false);
        return cnn;
        
    }
    
    public static void cerrarConexion(Connection cnn) throws SQLException{
        cnn.commit();
        cnn.close();
    }
    
    public static void cancelarTran(Connection cnn) throws SQLException{
        cnn.rollback();
        cnn.close();
    }

    public static void cerrarCnn(Connection cnn) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void reversarCnn(Connection cnn) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}  // Fin Clase conexion
