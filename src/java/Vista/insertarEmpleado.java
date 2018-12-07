/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.vo.Empleado;
import control.ConntrolEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AppException;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "insertarEmpleado", urlPatterns = {"/insertarEmpleado"})
public class insertarEmpleado extends GenericoSrv {
Connection cnn = null;

    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {

        switch (urlServlet) {
            case "/insertarEmpleado":
                String nom = request.getParameter("nombre");
                String ape = request.getParameter("apellido");
                String cel = request.getParameter("celular");
                String dir = request.getParameter("direccion");
                String corr = request.getParameter("correo");
                String car = request.getParameter("cargo");
                if ( (nom != null) && (ape != null)&&(cel != null) && (dir != null)&&(corr != null) && (car != null)) {
                    Empleado vo = new Empleado();                    
                    vo.setNombre(nom);
                    vo.setApellido(ape);
                    vo.setCelular(car);
                    vo.setDireccion(dir);
                    vo.setCorreo(corr);
                    vo.setCargo(car);
                    ConntrolEmpleado empleado = new ConntrolEmpleado(cnn);
                    empleado.insertar(vo);
                      if (vo != null) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("empleado", vo);
                        response.sendRedirect(request.getContextPath() + "/Home");
                    }

                }
                out.println("<form methods=\"POST\">"
            + "<div id=\"IngresarEmpleado\">"
            + "<div>"
            + "<label for=\"titulo\"> INGRESAR EMPLEADO </label>"
            + "</div>"
            + "<div>"
            + "<label for=\"nombre\">Nombre :</label>"
            + "<input type=\"text\" id=\"nombre\" name=\"nombre\">"
            + "</div>"
            + "<div>"
            + "<label for=\"apellido\">Apellido :</label>"
            + "<input type=\"text\" id=\"apellido\" name=\"apellido\">"
            + "</div>"
            + "<div>"
            + "<label for=\"celular\">Celular :</label>"
            + "<input type=\"text\" id=\"celular\" name=\"celular\">"
            + "</div>"
            + "<div>"
            + "<label for=\"direccion\">Direccion :</label>"
            + "<input type=\"text\" id=\"direccion\" name=\"direccion\">"
            + "</div>"
            + "<div>"
            + "<label for=\"correo\">Correo :</label>"
            + "<input type=\"text\" id=\"correo\" name=\"correo\">"
            + "</div>"
            + "<div>"
            + "<label for=\"cargo\">Cargo :</label>"
            + "<input type=\"text\" id=\"cargo\" name=\"cargo\">"
            + "</div>"
            + "<div>"
            + "<input class=\"botones\" type=\"reset\" id=\"btnCancelar\" value=\"Cancelar\">"
            + "<input class=\"botones\" type=\"submit\" id=\"btnAceptar\" value=\"Aceptar\">"
            + "<input class=\"botones\" type=\"submit\" id=\"btnMenu\" value=\"Menu\">"
            + "</div>"
            + "</div>"
            + "</form>");
                 break;
        }

            
            
        }
         
    }




