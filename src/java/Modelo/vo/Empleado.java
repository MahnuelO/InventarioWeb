package Modelo.vo;

/**
 *
 * @author Administrador
 */
public class Empleado {
private int idempleado;
    private String nombre;
    private String apellido;
    private String celular;
    private String direccion;
    private String correo;
    private String cargo;

   
    public int getIdempleado() {
        return idempleado;
    }

    
    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

   
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getApellido() {
        return apellido;
    }

  
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    public String getCelular() {
        return celular;
    }

  
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    public String getDireccion() {
        return direccion;
    }

  
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    public String getCargo() {
        return cargo;
    }

    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

//    public void setFecharegistro(Date date) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}  // Fin Clase Empleado
