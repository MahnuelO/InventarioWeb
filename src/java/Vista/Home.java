/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import control.ControlUsuario;
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
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends GenericoSrv {

   
   @Override
    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {

        switch (urlServlet) {
            case "/home":
                HttpSession sesion = request.getSession();
                Usuario vo = (Usuario)sesion.getAttribute("usuario");
                out.println("<h1>HOME "+vo.getNombre()+"</h1>");
               
                break;
        }

    }

}
