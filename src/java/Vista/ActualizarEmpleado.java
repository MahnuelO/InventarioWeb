/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion.conexion;
import Modelo.vo.Empleado;
import control.ConntrolEmpleado;
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
 * @author MAHNUEL
 */
@WebServlet(name = "ActualizarEmpleado", urlPatterns = {"/ActualizarEmpleado"})
public class ActualizarEmpleado extends GenericoSrv {

    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {

        switch (urlServlet) {
            case "/ActualizarEmpleado":
                String idE = request.getParameter("idempleado");
                String nom = request.getParameter("nombre1");
                String ape = request.getParameter("apellido1");
                String cel = request.getParameter("celular1");
                String dir = request.getParameter("direccion1");
                String corr = request.getParameter("correo1");
                String car = request.getParameter("cargo1");

                cnn = conexion.getConexionDB();
                Empleado am;

                if ((nom == null) && (ape == null) && (cel == null) && (dir == null) && (corr == null) && (car == null)) {

                    ConntrolEmpleado control = new ConntrolEmpleado(cnn);

                    if (request.getParameter("id") != null) {

                        am = control.consultarIdempleado(Integer.parseInt(request.getParameter("id")));
                    } else {

                        am = new Empleado();
                    }

                } else {
                    am = new Empleado();

                    am.setNombre(nom);
                    am.setApellido(ape);
                    am.setCelular(cel);
                    am.setDireccion(dir);
                    am.setCorreo(corr);
                    am.setCargo(car);
                    am.setIdempleado(Integer.parseInt(idE));
                    ConntrolEmpleado em = new ConntrolEmpleado(cnn);
                    em.modificar(am);
                    conexion.cerrarConexion(cnn);
                    response.sendRedirect(request.getContextPath() + "/Home");

                }

                out.println("<form methods=\"POST\">"
                        + "<div id=\"ActualizarEmpleado\">"
                        + "<div>"
                        + "<label for=\"titulo\"> ACTUALIZAR EMPLEADO </label>"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"idempleado\">IdEmpleado :</label>"
                        + "<input  id=\"idempleado\" name=\"idempleado\" value=\" " + am.getIdempleado() + "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"nombre\">Nombre :</label>"
                        + "<input  id=\"nombre\" name=\"nombre\" value=\" " + am.getNombre() + "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"apellido\">Apellido :</label>"
                        + "<input  id=\"apellido\" name=\"apellido\" value=\" " + am.getApellido() + "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"celular\">Celular :</label>"
                        + "<input  id=\"celular\" name=\"celular\" value=\" " + am.getCelular() + "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"direccion\">Direccion :</label>"
                        + "<input  id=\"direccion\" name=\"direccion\" value=\" " + am.getDireccion() + "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"correo\">Correo :</label>"
                        + "<input  id=\"correo\" name=\"correo\" value=\" " + am.getCorreo() + "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"cargo\">Cargo :</label>"
                        + "<input  id=\"cargo\" name=\"cargo\" value=\" " + am.getCargo() + "\">"
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
