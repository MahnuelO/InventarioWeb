/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.vo.Producto;
import control.ControlProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
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
 * @author Usuario
 */
@WebServlet(name = "Producto", urlPatterns = {"/Producto"})
public class InsertarProducto extends GenericoSrv {

      Connection cnn = null;
    
    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {
     switch (urlServlet) {
            case "/Producto":
                String nom = request.getParameter("nombre");
                String cp = request.getParameter("cantidadp");
                String tp = request.getParameter("tipop");
                String prp = request.getParameter("preciop"); 
                String fe = request.getParameter("fecharegistro");
                String emp  = request.getParameter("descripcion");
                if ((nom != null) && (cp != null) && (tp != null) && (prp != null) && (emp != null)/*&& (fe != null)*/) {
                    Producto vo = new Producto();
                    vo.setNombre(nom);
                    vo.setCantidadp(Integer.parseInt(cp));
                    vo.setTipop(tp);
                    vo.setPreciop(Integer.parseInt(prp));
                    vo.setDescripcion(emp);
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    vo.setFecharegistro(formato.parse(fe));
                    ControlProducto producto = new ControlProducto(cnn);
                    producto.insertar(vo);
                    if (vo != null) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("producto", vo);
                        response.sendRedirect(request.getContextPath() + "/Home");
                    }
 
                }
                out.println("<form methods=\"POST\">"
                        + "<div id=\"IngresarProducto\">"
                        + "<div>"
                        + "<label for=\"titulo\"> INGRESAR PRODUCTO </label>"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"nombre\">Nombre :</label>"
                        + "<input type=\"text\" id=\"nombre\" name=\"nombre\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"cantidadp\">Cantidad :</label>"
                        + "<input type=\"text\" id=\"cantidadp\" name=\"cantidadp\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"tipop\">Tipo :</label>"
                        + "<input type=\"text\" id=\"tipop\" name=\"tipop\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"preciop\">Precio :</label>"
                        + "<input type=\"text\" id=\"preciop\" name=\"preciop\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"descripcion\">Descripcion :</label>"
                        + "<input type=\"text\" id=\"descripcion\" name=\"descripcion\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"fecharegistro\">Fecha de Registro :</label>"
                        + "<input type=\"text\" id=\"fecharegistro\" name=\"fecharegistro\">"
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
