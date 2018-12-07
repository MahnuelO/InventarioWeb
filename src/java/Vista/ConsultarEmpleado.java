/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion.conexion;
import Modelo.vo.Empleado;
import control.ConntrolEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AppException;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ConsultarEmpleado", urlPatterns = {"/ConsultarEmpleado"})
public class ConsultarEmpleado extends GenericoSrv {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection cnn = null;
        try (PrintWriter out = response.getWriter()) {
            try {

                cnn = conexion.getConexionDB();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConsultarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ConsultarEmpleado</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/consultarempleado.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"POST\">");
            out.println("<div id=\"ConsultarEmpleado\">");
            out.println("<div>");
            out.println("<label for=\"titulo\"> CONSULTAR EMPLEADO</label>");
            out.println("</div>");
            out.println("<div>");
//            out.println("<label for=\"nombre\">Nombre</label>");
//            out.println("<input type=\"text\" name=\"nombre\" name=\"nombre\">");
            out.println("</div>");
            out.println("<table border=\"2\" cellpadding=\"10\" cellspacing=\"6\">");
            out.println("<tr>");
            out.println("<th>Id Empleado</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Apellido</th>");
            out.println("<th>Celular</th>");
            out.println("<th>Direccion</th>");
            out.println("<th>Correo</th>");
            out.println("<th>Cargo</th>");
            out.println("</tr>");

            ConntrolEmpleado cem = new ConntrolEmpleado(cnn);

            for (Empleado em : cem.consultar()) {
                out.println("<tr>");
                out.println("<td>  " + em.getIdempleado() + "    </td>");
                out.println("<td>  " + em.getNombre() + "    </td>");
                out.println("<td>" + em.getApellido() + "  </td>");
                out.println("<td>" + em.getCelular() + " </td>");
                out.println("<td>" + em.getDireccion() + " </td>");
                out.println("<td>" + em.getCorreo() + " </td>");
                out.println("<td>" + em.getCargo() + " </td>");
               // out.println("<td><a href=\"" + request.getContextPath() + "/ActualizarEmpleado" + "\">Actualizar Empleado</a> </td>");
                out.println("<td><a href=\""+request.getContextPath()+"//ActualizarEmpleado?id="+em.getIdempleado()+"\">Actualizar Empleado</a>");
                out.println("</tr>");

            }

            out.println("</table>");
            out.println("<div>");
//            out.println("<input class=\"botones\" type=\"submit\" id=\"btnConsultar\" value=\"Consultar\">");
//            out.println("<input class=\"botones\" type=\"submit\" id=\"btnMenu\" value=\"Menu\">");
            out.println("</div>");
            out.println("</div>");
            out.println("</form>");

        }
    }

    @Override
    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
