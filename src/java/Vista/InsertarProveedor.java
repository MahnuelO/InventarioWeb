/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Proveedor", urlPatterns = {"/Proveedor"})
public class InsertarProveedor extends HttpServlet {

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
            out.println("<title>Insertar Proveedor</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/proveedor.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form methods=\"POST\">");
            out.println("<div id=\"IngresarProveedor\">");
            out.println("<div>");
            out.println("<label for=\"titulo\"> INGRESAR PROVEEDOR </label>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"nombre\">Nombre :</label>");
            out.println("<input type=\"text\" id=\"nombre\" name=\"nombre\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"apellido\">Apellido :</label>");
            out.println("<input type=\"text\" id=\"apellido\" name=\"apellido\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"celular\">Celular :</label>");
            out.println("<input type=\"text\" id=\"celular\" name=\"celular\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"correo\">Correo :</label>");
            out.println("<input type=\"text\" id=\"correo\" name=\"correo\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"empresa\">Empresa :</label>");
            out.println("<input type=\"text\" id=\"empresa\" name=\"empresa\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"direccion empresa\">Direccion Empresa :</label>");
            out.println("<input type=\"text\" id=\"direccion empresa\" name=\"direccion empresa\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"fecha registro\">Fecha de Registro :</label>");
            out.println("<input type=\"text\" id=\"fecha registro\" name=\"fecha registro\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<input class=\"botones\" type=\"reset\" id=\"btnCancelar\" value=\"Cancelar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnAceptar\" value=\"Aceptar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnMenu\" value=\"Menu\">");
            out.println("</div>");
            out.println("</div>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
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
