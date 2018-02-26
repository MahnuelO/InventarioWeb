/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion.conexion;
import Modelo.vo.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "vista", urlPatterns = {"/vista"})
public class vista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form methods=\"post\">");
            out.println("<div id =\"LOGIN\">");
            out.println("<div>");
            out.println("<label for=\"titulo\"> LOGIN </label>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"nombre\">Nombre de Usuario: </label>");
            out.println("<input type=\"tex\" id=\"nombre\" name=\"nombre\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"clave\"> Clave: </label>");
            out.println("<input type=\"password\" name=\"clave\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<input class=\"botones\" type=\"reset\" id=\"btnCancelar\" value=\"Cancelar\">");
           
            out.println("<a href=\"Menu\">Aceptar</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
    
           // response.sendRedirect("Menu");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
