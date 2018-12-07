package Vista;

import Modelo.conexion.conexion;
import Modelo.vo.Producto;
import control.ControlProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AppException;

/**
 *
 * @author MAHNUEL
 */
@WebServlet(name = "ActualizarProducto", urlPatterns = {"/ActualizarProducto"})
public class ActualizarProducto extends GenericoSrv {

    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {

        switch (urlServlet) {
            case "/ActualizarProducto":
                String idPr = request.getParameter("idproducto");
                String nom = request.getParameter("nombre");
                String cp = request.getParameter("cantidadp");
                String tp = request.getParameter("tipop");
                String prp = request.getParameter("preciop");
                String fe = request.getParameter("fecharegistro");
                String emp = request.getParameter("descripcion");
                cnn = conexion.getConexionDB();
                Producto am;

                if ((nom == null) && (cp == null) && (tp == null) && (prp == null) && (emp == null) && (fe == null)) {

                    ControlProducto control = new ControlProducto(cnn);

                    if (request.getParameter("id") != null) {

                        am = control.consultarIdproducto(Integer.parseInt(request.getParameter("id")));
                    } else {

                        am = new Producto();
                    }

                } else {
                    am = new Producto();

                    am.setNombre(nom);
                    am.setCantidadp(Integer.parseInt(cp));
                    am.setTipop(tp);
                    am.setPreciop(Integer.parseInt(prp));
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    am.setFecharegistro(formato.parse(fe));
                    am.setDescripcion(emp);
                    am.setIdproducto(Integer.parseInt(idPr));
                    ControlProducto em = new ControlProducto(cnn);
                    em.modificar(am);
                    conexion.cerrarConexion(cnn);
                    response.sendRedirect(request.getContextPath() + "/Home");

                }
                out.println("<form methods=\"POST\">"
                        + "<div id=\"ActualizarProducto\">"
                        + "<div>"
                        + "<label for=\"titulo\"> ACTUALIZAR PRODUCTO </label>"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"idproducto\">Id Producto :</label>"
                        + "<input  id=\"idproducto\" name=\"idproducto\" value=\" " + am.getIdproducto()+ "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"nombre\">Nombre :</label>"
                        + "<input  id=\"nombre\" name=\"nombre\" value=\" " + am.getNombre()+ "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"cantidadp\">Cantidad :</label>"
                        + "<input  id=\"cantidadp\" name=\"cantidadp\" value=\" " + am.getCantidadp()+ "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"tipop\">Tipo :</label>"
                        + "<input  id=\"tipop\" name=\"tipop\" value=\" " + am.getTipop()+ "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"preciop\">Precio :</label>"
                        + "<input  id=\"preciop\" name=\"preciop\" value=\" " + am.getPreciop()+ "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"descripcion\">Descripcion :</label>"
                        + "<input  id=\"descripcion\" name=\"descripcion\" value=\" " + am.getDescripcion()+ "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"fecharegistro\">Fecha de Registro :</label>"
                        + "<input  id=\"fecharegistro\" name=\"fecharegistro\" value=\" " + am.getFecharegistro()+ "\">"
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
