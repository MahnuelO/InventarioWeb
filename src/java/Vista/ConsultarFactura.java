/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion.conexion;
import Modelo.vo.Factura;
import control.ControlFactura;
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
@WebServlet(name = "ConsultarFactura", urlPatterns = {"/ConsultarFactura"})
public class ConsultarFactura extends GenericoSrv {

   
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection cnn = null;
        try (PrintWriter out = response.getWriter()) {
            try {
              

                cnn = conexion.getConexionDB();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConsultarFactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ConsultarProducto</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/consultarproducto.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"POST\">");
            out.println("<div id=\"ConsultarFactura\">");
            out.println("<div>");
            out.println("<label for=\"titulo\"> CONSULTAR FACTURA</label>");
            out.println("</div>");
            out.println("<div>");

            out.println("</div>");
            out.println("<table border=\"2\" cellpadding=\"10\" cellspacing=\"6\">");
            out.println("<tr>");
            out.println("<th>Codigo Factura</th>");
            out.println("<th>Fecha de Factura</th>");
            out.println("<th>Tipo de Factura</th>");
            out.println("<th>Valor unitario</th>");
            out.println("<th>Valor Total</th>");
            out.println("<th>Descuento</th>");
            out.println("<th>Detalles</th>");
            out.println("<th>Devolucion</th>");
            out.println("</tr>");

            ControlFactura cem = new ControlFactura(cnn);

            for (Factura em : cem.consultar()) {
                out.println("<tr>");
                out.println("<td>  " + em.getCodfactura()+ "    </td>");
                out.println("<td>  " + em.getFechafactura()+ "    </td>");
                out.println("<td>" + em.getTipofactura()+ "  </td>");
                out.println("<td>" + em.getValorunitario()+ " </td>");
                out.println("<td>" + em.getValortotal()+ " </td>");
                out.println("<td>" + em.getDescuento()+ " </td>");
                out.println("<td>" + em.getDetalles()+ " </td>");
                out.println("<td>" + em.getDevolucion()+ " </td>");
                

                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<div>");

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
