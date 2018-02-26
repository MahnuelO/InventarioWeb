package control;
import Modelo.dao.EmpleadoDAO;
import Modelo.vo.Empleado;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ConntrolEmpleado {
 Connection cnn;
    EmpleadoDAO dao;
    
    public ConntrolEmpleado(Connection cnn){
        this.cnn = cnn;
        this.dao = new EmpleadoDAO(cnn);
    }
    
    public boolean insertar(Empleado vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getApellido() == null || vo.getApellido().isEmpty()
                || vo.getCelular() == null || vo.getCelular().isEmpty()){
            return false;
        }else{
            try {
                dao.insertar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        
    }
    
   public boolean modificar(Empleado vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getApellido() == null || vo.getApellido().isEmpty()
                || vo.getCelular() == null || vo.getCelular().isEmpty()
                || vo.getIdempleado() == 0){
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
    
//    public boolean borrar(Empleado vo){
//        if(vo.getIdempleado() == 0){
//            return false;
//        }else{
//            try {
//                dao.borrar(vo);
//                return true;
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//                return false;
//            }
//        }
//    }
//    
    public List<Empleado> consultar(){
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}  // Fin Clase ConntrolEmpleado
