/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import control.ControlUsuario;
import Modelo.vo.Usuario;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CrearUsuario", urlPatterns = {"/CrearUsuario"})
public class CrearUsuario extends GenericoSrv {

    Connection cnn = null;

    @Override
    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {

        switch (urlServlet) {
            case "/CrearUsuario":
                String idusuar = request.getParameter("idusuario");
                String nom = request.getParameter("nombre");
                String clav = request.getParameter("clave");
                if ( (nom != null) && (clav != null)) {
                    Usuario vo = new Usuario();                    
                    vo.setNombre(nom);
                    vo.setClave(clav);
                    ControlUsuario user = new ControlUsuario(cnn);
                    user.insert(vo);
                      if (vo != null) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("usuario", vo);
                        response.sendRedirect(request.getContextPath() + "/Home");
                    }

                }

                out.println("<form methods=\"POST\">\n"
                        + "      	<div id=\"IngresarEmpleado\">\n"
                        + "      		<div>\n"
                        + "      			<label for=\"titulo\"> REGISTRO USUARIO </label>\n"
                        + "      		</div>\n"
                        + "               <div>\n"
                        + "      			<label for=\"idusuario\">Id Usuario :</label>\n"
                        + "      			<input type=\"text\" id=\"idusuario\" name=\"idusuario\">\n"
                        + "      		</div>\n"
                        + "             <div>\n"
                        + "      			<label for=\"nombre\">Nombre :</label>\n"
                        + "      			<input type=\"text\" id=\"nombre\" name=\"nombre\">\n"
                        + "      		</div>\n"
                        + "      		<div>\n"
                        + "      			<label for=\"clave\">Clave :</label>\n"
                        + "      			<input type=\"password\" id=\"clave\" name=\"clave\">\n"
                        + "      		</div>\n"
                        + "      		<div>\n"
                        + "      			<input class=\"botones\" type=\"reset\" id=\"btnCancelar\" value=\"Cancelar\">\n"
                        + "      		    <input class=\"botones\" type=\"submit\" id=\"btnAceptar\" value=\"Aceptar\">\n"
                        + "      		</div>  \n"
                        + "      	</div>\n"
                        + "      </form>");
                break;

        }

    }

}
