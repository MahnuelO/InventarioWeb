package Vista;

import Modelo.vo.Factura;
import Modelo.vo.FacturaProducto;
import Modelo.vo.Producto;
import control.ControlFacturaProducto;
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

@WebServlet(name = "InsertarDetalleFactura", urlPatterns = {"/InsertarDetalleFactura"})
public class InsertarDetalleFactura extends GenericoSrv {

    Connection cnn = null;

    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {

        switch (urlServlet) {
            case "/InsertarDetalleFactura":
                String nom = request.getParameter("cantidatotal");
                String corr = request.getParameter("subtotal");
                String ip = request.getParameter("idproducto");
                String cf = request.getParameter("codfactura");
                if ((nom != null) && (corr != null)) {
                    FacturaProducto vo = new FacturaProducto();
                    vo.setIdproducto(Integer.parseInt(ip));
                    vo.setCodfactura(Integer.parseInt(cf));
                    vo.setCantidadtotal(Integer.parseInt(nom));
                    vo.setSubtotal(Double.parseDouble(corr));
                    ControlFacturaProducto amigo = new ControlFacturaProducto(cnn);
                    amigo.insertar(vo);
                    if (vo != null) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("detallefactura", vo);
                        response.sendRedirect(request.getContextPath() + "/Home");

                    }

                }
                out.println("<form methods=\"POST\">\n"
                        + "            <div id=\"InsertarDetalleFactura\">\n"
                        + "                <div>\n"
                        + "                    <label for=\"titulo\"> INGRESAR DETALLE FACTURA </label>\n"
                        + "                </div>\n"
                        + "\n"
                        + "                <div>\n"
                        + "                    <label for=\"cantidatotal\">Cantidad Total :</label>\n"
                        + "                    <input type=\"text\" id=\"cantidatotal\" name=\"cantidatotal\">\n"
                        + "                </div>\n"
                        + "                <div>\n"
                        + "                    <label for=\"subtotal\">SubTotal :</label>\n"
                        + "                    <input type=\"text\" id=\"subtotal\" name=\"subtotal\">\n"
                        + "                </div>\n"
                        + "                <div>\n"
                        + "                    <label for=\"idproducto\">Id Producto :</label>\n"
                        + "                    <input type=\"text\" id=\"idproducto\" name=\"idproducto\">\n"
                        + "                </div>\n"
                        + "                <div>\n"
                        + "                    <label for=\"codfactura\">Codigo Factura :</label>\n"
                        + "                    <input type=\"text\" id=\"codfactura\" name=\"codfactura\">\n"
                        + "                </div>\n"
                        + "\n"
                        + "\n"
                        + "            <div>\n"
                        + "                <input class=\"botones\" type=\"reset\" id=\"btnCancelar\" value=\"Cancelar\">\n"
                        + "                <input class=\"botones\" type=\"submit\" id=\"btnAceptar\" value=\"Aceptar\">\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </form>\n"
                        + "");
                break;
        }
    }

}
