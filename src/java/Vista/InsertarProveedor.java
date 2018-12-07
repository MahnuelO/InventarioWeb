
package Vista;


import Modelo.vo.Proveedor;
import control.ControlProveedor;
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
 * @author Usuario
 */
@WebServlet(name = "Proveedor", urlPatterns = {"/Proveedor"})
public class InsertarProveedor extends GenericoSrv {

    Connection cnn = null;

    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {

        switch (urlServlet) {
            case "/Proveedor":
                String nom = request.getParameter("nombre");
                String ape = request.getParameter("apellido");
                String cel = request.getParameter("celular");
                String corr = request.getParameter("correo");
                String emp  = request.getParameter("empresa");
                String dire = request.getParameter("direccionempresa");
             String fe = request.getParameter("fecharegistro");
                if ((nom != null) && (ape != null) && (cel != null) && (corr != null) && (emp != null) && (dire != null) /*&& (fe != null)*/) {
                    Proveedor vo = new Proveedor();
                    vo.setNombre(nom);
                    vo.setApellido(ape);
                    vo.setCelular(cel);
                    vo.setCorreo(corr);
                    vo.setEmpresa(emp);
                    vo.setDireccionempresa(dire);
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    vo.setFecharegistro(formato.parse(fe));
                    ControlProveedor proveedor = new ControlProveedor(cnn);
                    proveedor.insertar(vo);
                    if (vo != null) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("proveedor", vo);
                        response.sendRedirect(request.getContextPath() + "/Home");
                    }
 
                }
                out.println("<form methods=\"POST\">"
                        + "<div id=\"IngresarEmpleado\">"
                        + "<div>"
                        + "<label for=\"titulo\"> INGRESAR PROVEEDOR </label>"
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
                        + "<label for=\"correo\">Correo :</label>"
                        + "<input type=\"text\" id=\"correo\" name=\"correo\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"empresa\">Empresa :</label>"
                        + "<input type=\"text\" id=\"empresa\" name=\"empresa\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"direccionempresa\">Direccion Empresa :</label>"
                        + "<input type=\"text\" id=\"direccionempresa\" name=\"direccionempresa\">"
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
