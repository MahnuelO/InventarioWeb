/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion.conexion;
import utils.AppException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "GenericoSrv", urlPatterns = {"/GenericoSrv"})
public abstract class GenericoSrv extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control","no-store,no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        try (PrintWriter out = response.getWriter()) {
            String err = null;
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("usuario") == null && !request.getServletPath().equals("/usuario/login") && !request.getServletPath().equals("/usuario/crear") && !request.getServletPath().equals("/CrearUsuario") ) {
                response.sendRedirect("usuario/login");
            } else if (sesion.getAttribute("usuario") != null && (request.getServletPath().equals("/usuario/login"))) {
                response.sendRedirect(request.getContextPath() + "/Home");
            }
            err = request.getParameter("e");
            if (err != null) {
                out.print("<script type=\"text/javascript\">\n"
                        + "		alert(\"Error" +err+"\");\n"
                        + "	</script>");
                out.println("<h3>Error " + err + "</h3>");
                //request.getRequestDispatcher(request.getContextPath() + request.getServletPath() + "?e=" + err).forward(request,response);
                //response.sendRedirect(request.getContextPath() + request.getServletPath() + "?e=" + err);
                //return;
            }
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "	<title></title>\n"
                    + "	<link rel=\"stylesheet\" type=\"text/css\" href=\"" + request.getContextPath() + "/css/estilos.css\">\n"
                    + "</head>\n"
                    + "<body>");
            
            Connection cnn = null;
            try {
                cnn = conexion.getConexionDB();
                
                if (!request.getServletPath().equals("/usuario/login") && !request.getServletPath().equals("/usuario/crear")) {
                    out.println("<div>\n"
                            + "		<a href=\"#\">HOME</a>  \n"
                            + "		<a href=\"#\">P1</a>  \n"
                            + "		<a href=\"#\">P2</a>  \n"
                            + "		<a href=\"#\">P3</a>  \n"
                            + "		<a href=\"#\">P4</a>  \n"
                            + "		<a href=\"#\">P5</a>  \n"
                            + "		<a href=\"" + request.getContextPath() + "/CerrarSesion" + "\">Cerrar Sesion</a>  \n"
                            + "	</div>");
                }
                
                procesarServlet(out, cnn, request.getServletPath(), request, response);
                conexion.cerrarConexion(cnn);
            } catch (AppException e) {
                //e.printStackTrace();
                //out.print("<script>alert(\"Error de Ejecucion\"" + e.getMessage() + ");</script>");
                err = e.getMessage().substring(e.getMessage().indexOf(" "));
                request.getRequestDispatcher(request.getServletPath() + "?e=" + err).forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                conexion.reversarCnn(cnn);
            }
            
            out.println("</body>\n"
                    + "</html>");
            
        }
    }
     public abstract void procesarServlet(PrintWriter out, Connection cnn, String urlServlet,
            HttpServletRequest request,
            HttpServletResponse response) throws AppException, Exception;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
