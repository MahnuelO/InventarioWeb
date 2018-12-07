/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion.conexion;
import Modelo.vo.Proveedor;
import control.ControlProveedor;
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
 * @author Mahnuel
 */
@WebServlet(name = "ConsultarProveedor", urlPatterns = {"/ConsultarProveedor"})
public class ConsultarProveedor extends GenericoSrv {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection cnn = null;
        try (PrintWriter out = response.getWriter()) {
            try {
                cnn = conexion.getConexionDB();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConsultarProveedor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ConsultarProveedor</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/consultarempleado.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"POST\">");
            out.println("<div id=\"ConsultarProveedor\">");
            out.println("<div>");
            out.println("<label for=\"titulo\"> CONSULTAR PROVEEDOR</label>");
            out.println("</div>");
            out.println("<div>");
            out.println("</div>");
            out.println("<table border=\"2\" cellpadding=\"10\" cellspacing=\"6\">");
            out.println("<tr>");
            out.println("<th>Id Proveedor</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Apellido</th>");
            out.println("<th>Celular</th>");
            out.println("<th>Correo</th>");
            out.println("<th>Empresa</th>");
            out.println("<th>Direccion Empresa</th>");
            out.println("<th>Fecha Registro</th>");
            out.println("</tr>");

            ControlProveedor cpo = new ControlProveedor(cnn);

            for (Proveedor po : cpo.consultar()) {
             
                out.println("<tr>");
                out.println("<td>" + po.getIdproveedor() + "</td>");
                out.println("<td>" + po.getNombre() + "</td>");
                out.println("<td>" + po.getApellido() + "</td>");
                out.println("<td>" + po.getCelular() + "</td>");
                out.println("<td>" + po.getCorreo() + "</td>");
                out.println("<td>" + po.getEmpresa() + "</td>");
                out.println("<td>" + po.getDireccionempresa() + "</td>");
                out.println("<td>" + po.getFecharegistro() + "</td>");
               out.println("<td><a href=\""+request.getContextPath()+"//ActualizarProveedor?id="+po.getIdproveedor()+"\">Actualizar Producto</a>");
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
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
