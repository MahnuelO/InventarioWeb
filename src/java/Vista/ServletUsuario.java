/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import control.ControlUsuario;
import Modelo.conexion.conexion;
import Modelo.vo.Empleado;
import Modelo.vo.Usuario;
import utils.AppException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/usuario/login", "/usuario/crear"})
public class ServletUsuario extends GenericoSrv {

   
    @Override
    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException,Exception {

        switch (urlServlet) {
            case "/usuario/login":

                String nombre = request.getParameter("nombre");
                String clave = request.getParameter("clave");
                String error = request.getParameter("e");

                if (nombre != null && clave != null && error == null) {
                    ControlUsuario control = new ControlUsuario(cnn);
                    Usuario vo = control.query(nombre, clave);
                    if (vo != null) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("usuario", vo);
                        response.sendRedirect(request.getContextPath() + "/Home");
                    }
                }

                out.println("<form method=\"POST\" action=\"login\">\n"
                        + "		<div id=\"contenidoLogin\">\n"
                        + "			<div>\n"
                        + "				<label for=\"nombre\">Nombre :</label>\n"
                        + "				<input type=\"text\" id=\"nombre\" name=\"nombre\">\n"
                        + "			</div>\n"
                        + "			<div>\n"
                        + "				<label for=\"clave\">Clave :</label>\n"
                        + "				<input type=\"password\" id=\"clave\" name=\"clave\">\n"
                        + "			</div>\n"
                        + "			<div>\n"
                        + "				<input class=\"botones\" type=\"reset\" id=\"btnCancelar\" value=\"Cancelar\">\n"
                        + "				<input class=\"botones\" type=\"submit\" id=\"btnAceptar\" value=\"Aceptar\">\n"
                        + "			</div>	\n"
                        + "		</div>	\n"
                        + "	</form>");
                break;
        }

    }


}
