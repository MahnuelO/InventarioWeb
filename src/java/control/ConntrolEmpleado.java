package control;
import Modelo.dao.EmpleadoDAO;
import Modelo.vo.Empleado;
import Modelo.vo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import utils.AppException;

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
    public void insertar(Empleado vo) throws AppException{
        try {
            if(vo.getNombre().isEmpty()){
                throw new AppException("Campo Nombre incompleto");
            }
            if(dao.queryNombre(vo.getNombre()) != null){
                throw new AppException("Empleado ya existe");
            }
            dao.insertar(vo);
        } catch (Exception e) {
            throw new AppException(e);
        }
    }
    
//    public boolean insertar(Empleado vo){
//        if(vo.getNombre()== null || vo.getNombre().isEmpty()
//                || vo.getApellido() == null || vo.getApellido().isEmpty()
//                || vo.getCelular() == null || vo.getCelular().isEmpty()){
//            return false;
//        }else{
//            try {
//                dao.insertar(vo);
//                return true;
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//                return false;
//            }
//        }
//        
//    }
//    
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
    
     public Empleado consultarIdempleado(int idempleado) throws ParseException{
        try {
            return dao.consultaridEmpleado(idempleado);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
     
}  // Fin Clase ConntrolEmpleado
