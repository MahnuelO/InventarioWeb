/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.vo.Factura;
import control.ControlFactura;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AppException;

/**
 *
 * @author MAHNUEL
 */
@WebServlet(name = "InsertarFactura", urlPatterns = {"/InsertarFactura"})
public class InsertarFactura extends GenericoSrv {
    
    Connection cnn = null;

    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception{
    
        switch (urlServlet){
            case "/InsertarFactura":
                String ff = request.getParameter("fechafactura");
                String tf = request.getParameter("tipofactura");
                String vu = request.getParameter("valorunitario");
                String vt = request.getParameter("valortotal");
                String de = request.getParameter("descuento");
                String det = request.getParameter("detalles");
                String ie = request.getParameter("idempleado");
                String dev = request.getParameter("devolucion");
                if ((ff != null) && (tf != null) && (vu != null) && (vt != null) && (de != null) && (det != null) && (ie != null) && (dev != null)) {
                    Factura vo = new Factura();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    vo.setFechafactura(formato.parse(ff));
                    vo.setTipofactura(tf);
                    vo.setValorunitario(Integer.parseInt(vu));
                    vo.setValortotal(Integer.parseInt(vt));
                    vo.setDescuento(Double.parseDouble(de));
                    vo.setDetalles(det);
                    vo.setIdempleado(Integer.parseInt(ie));
                    vo.setDevolucion(Double.parseDouble(dev));
                    ControlFactura factura = new ControlFactura(cnn);
                    factura.insertar(vo);
                    if (vo != null) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("factura", vo);
                        response.sendRedirect(request.getContextPath()+ "/Home");
                        
                    }
                    
                }
             out.println("<form methods=\"POST\">"
                        + "<div id=\"IngresarFactura\">"
                        + "<div>"
                        + "<label for=\"titulo\"> INGRESAR FACTURA </label>"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"tipofactura\">Tipo Factura :</label>"
                        + "<input type=\"text\" id=\"tipofactura\" name=\"tipofactura\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"fechafactura\">Fecha de Registro :</label>"
                        + "<input type=\"text\" id=\"fechafactura\" name=\"fechafactura\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"valorunitario\">Valor unitario :</label>"
                        + "<input type=\"text\" id=\"valorunitario\" name=\"valorunitario\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"valortotal\">Valor Total :</label>"
                        + "<input type=\"text\" id=\"valortotal\" name=\"valortotal\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"descuento\">Descuento :</label>"
                        + "<input type=\"text\" id=\"descuento\" name=\"descuento\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"detalles\">Detalles :</label>"
                        + "<input type=\"text\" id=\"detalles\" name=\"detalles\">"
                        + "</div>"
                         + "<div>"
                        + "<label for=\"idempleado\">Id Empleado :</label>"
                        + "<input type=\"text\" id=\"idempleado\" name=\"idempleado\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"devolucion\">Devolucion :</label>"
                        + "<input type=\"text\" id=\"devolucion\" name=\"devolucion\">"
                        + "</div>"
                        + "<div>"
                        + "<input class=\"botones\" type=\"reset\" id=\"btnCancelar\" value=\"Cancelar\">"
                        + "<input class=\"botones\" type=\"submit\" id=\"btnAceptar\" value=\"Aceptar\">"
                        + "</div>"
                        + "</div>"
                        + "</form>");
                break;
        }
    }
}
