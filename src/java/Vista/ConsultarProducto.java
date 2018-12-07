/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion.conexion;
import Modelo.vo.Producto;
import control.ConntrolEmpleado;
import control.ControlProducto;
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
@WebServlet(name = "ConsultarProducto", urlPatterns = {"/ConsultarProducto"})
public class ConsultarProducto extends GenericoSrv {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection cnn = null;
        try (PrintWriter out = response.getWriter()) {
            try {
              

                cnn = conexion.getConexionDB();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConsultarProducto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ConsultarProducto</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/consultarproducto.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"POST\">");
            out.println("<div id=\"ConsultarProducto\">");
            out.println("<div>");
            out.println("<label for=\"titulo\"> CONSULTAR PRODUCTO</label>");
            out.println("</div>");
            out.println("<div>");
//            out.println("<label for=\"nombre\">Nombre</label>");
//            out.println("<input type=\"text\" name=\"nombre\" name=\"nombre\">");
            out.println("</div>");
            out.println("<table border=\"2\" cellpadding=\"10\" cellspacing=\"6\">");
            out.println("<tr>");
            out.println("<th>Id Producto</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Cantidad</th>");
            out.println("<th>Tipo</th>");
            out.println("<th>Precio</th>");
            out.println("<th>Fecha Registro</th>");
            out.println("<th>Descripcion</th>");
            out.println("</tr>");

            ControlProducto cem = new ControlProducto(cnn);

            for (Producto em : cem.consultar()) {
                out.println("<tr>");
                out.println("<td>  " + em.getIdproducto()+ "    </td>");
                out.println("<td>  " + em.getNombre() + "    </td>");
                out.println("<td>" + em.getCantidadp()+ "  </td>");
                out.println("<td>" + em.getTipop()+ " </td>");
                out.println("<td>" + em.getPreciop()+ " </td>");
                out.println("<td>" + em.getFecharegistro()+ " </td>");
                out.println("<td>" + em.getDescripcion()+ " </td>");
                 out.println("<td><a href=\""+request.getContextPath()+"//ActualizarProducto?id="+em.getIdproducto()+"\">Actualizar Producto</a>");
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
