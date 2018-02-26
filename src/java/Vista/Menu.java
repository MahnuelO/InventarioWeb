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
 * @author MAHNUEL
 */
@WebServlet(name = "Menu", urlPatterns = {"/Menu"})
public class Menu extends HttpServlet {

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
            out.println("<title>Menu</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/menu.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println(" <form methods=\"POST\">");
            out.println("<div id=\"menu\">");
            out.println("<div>");
            out.println("<label for=\"titulo\"> MENU </label>");
            out.println("</div>");
            out.println("<div>");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnEmpleado\" value=\"EMPLEADO\">");
            out.println(" <input class=\"botones\" type=\"submit\" id=\"btnInsertar\" value=\" Insertar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnConsultar\" value=\"Consultar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnActualizar\" value=\"Actualizar\">");
            out.println("<input class=\"botones\" type=\"reset\" id=\"btnEliminar\" value=\"Eliminar\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnProducto\" value=\"PRODUCTO\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnInsertar\" value=\" Insertar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnConsultar\" value=\"Consultar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnActualizar\" value=\"Actualizar\">");
            out.println("<input class=\"botones\" type=\"reset\" id=\"btnEliminar\" value=\"Eliminar\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnProveedor\" value=\"PROVEEDOR\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnInsertar\" value=\" Insertar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnConsultar\" value=\"Consultar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnActualizar\" value=\"Actualizar\">");
            out.println("<input class=\"botones\" type=\"reset\" id=\"btnEliminar\" value=\"Eliminar\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnFactura\" value=\"FACTURA\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnInsertar\" value=\" Insertar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnConsultar\" value=\"Consultar\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnFacturaProducto\" value=\"FACTURA PRODUCTO\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnInsertar\" value=\" Insertar\">");
            out.println("<input class=\"botones\" type=\"submit\" id=\"btnConsultar\" value=\"Consultar\">");
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
