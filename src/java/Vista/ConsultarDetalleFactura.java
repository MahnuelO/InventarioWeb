/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion.conexion;
import Modelo.vo.FacturaProducto;
import control.ControlFacturaProducto;
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
import javax.servlet.http.HttpSession;
import utils.AppException;


@WebServlet(name = "ConsultarDetalleFactura", urlPatterns = {"/ConsultarDetalleFactura"})
public class ConsultarDetalleFactura extends GenericoSrv {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection cnn = null;
        try (PrintWriter out = response.getWriter()) {
            try {

                cnn = conexion.getConexionDB();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConsultarDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarDetalleFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ConsultarDetalleFactura</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/consultarempleado.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"POST\">");
            out.println("<div id=\"ConsultarDetalleFactura\">");
            out.println("<div>");
            out.println("<label for=\"titulo\"> CONSULTAR DETALLE FACTURA</label>");
            out.println("</div>");
            out.println("<div>");

            out.println("</div>");
            out.println("<table border=\"2\" cellpadding=\"10\" cellspacing=\"6\">");
            out.println("<tr>");
            out.println("<th>Id Producto</th>");
            out.println("<th>Codigo Factura</th>");
            out.println("<th>Cantidad Total</th>");
            out.println("<th>SubTotal</th>");
            out.println("<th>Id Factura Producto</th>");
            out.println("</tr>");
            HttpSession sesion = request.getSession();
            sesion.getAttribute("detallefactura");
            FacturaProducto obt = (FacturaProducto) sesion.getAttribute("detallefactura");
            ControlFacturaProducto cem = new ControlFacturaProducto(cnn);

            for (FacturaProducto am : cem.consultar()) {

                out.println("<tr>");
                out.println("<td>  " + am.getIdproducto() + "    </td>");
                out.println("<td>  " + am.getCodfactura() + "    </td>");
                out.println("<td>  " + am.getCantidadtotal() + "    </td>");
                out.println("<td>" + am.getSubtotal() + "  </td>");
                out.println("<td>" + am.getIdfacturaproducto() + " </td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<a href=\"" + request.getContextPath() + "/Home" + "\">Menu</a>");
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
