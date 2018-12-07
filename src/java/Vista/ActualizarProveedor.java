/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.conexion.conexion;
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
import utils.AppException;

/**
 *
 * @author MAHNUEL
 */
@WebServlet(name = "ActualizarProveedor", urlPatterns = {"/ActualizarProveedor"})
public class ActualizarProveedor extends GenericoSrv {

    public void procesarServlet(PrintWriter out, Connection cnn, String urlServlet, HttpServletRequest request, HttpServletResponse response) throws AppException, Exception {

        switch (urlServlet) {
            case "/ActualizarProveedor":
                String idP = request.getParameter("idproveedor");
                String nom = request.getParameter("nombre1");
                String ape = request.getParameter("apellido1");
                String cel = request.getParameter("celular1");
                String corr = request.getParameter("correo1");
                String emp = request.getParameter("empresa1");
                String dire = request.getParameter("direccionempresa1");
                String fe = request.getParameter("fecharegistro1");
                cnn = conexion.getConexionDB();
                Proveedor am;

                if ((nom == null) && (ape == null) && (cel == null) && (corr == null) && (emp == null) && (dire == null) && (fe == null)) {

                    ControlProveedor control = new ControlProveedor(cnn);

                    if (request.getParameter("id") != null) {

                        am = control.consultarIdproveedor(Integer.parseInt(request.getParameter("id")));
                    } else {

                        am = new Proveedor();
                    }

                } else {
                    am = new Proveedor();

                    am.setNombre(nom);
                    am.setApellido(ape);
                    am.setCelular(cel);
                    am.setCorreo(corr);
                    am.setEmpresa(emp);
                    am.setDireccionempresa(dire);
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
                    am.setFecharegistro(formato.parse(fe));
                    am.setIdproveedor(Integer.parseInt(idP));
                    ControlProveedor em = new ControlProveedor(cnn);
                    em.modificar(am);
                    conexion.cerrarConexion(cnn);
                    response.sendRedirect(request.getContextPath() + "/Home");

                }
                out.println("<form methods=\"POST\">"
                        + "<div id=\"ActualizarEmpleado\">"
                        + "<div>"
                        + "<label for=\"titulo\"> ACTUALIZAR PROVEEDOR </label>"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"idproveedor\">Id Proveedor :</label>"
                        + "<input  id=\"idproveedor\" name=\"idproveedor\" value=\" " + am.getIdproveedor() + "\">"
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
                        + "<label for=\"correo\">Correo :</label>"
                        + "<input  id=\"correo\" name=\"correo\" value=\" " + am.getCorreo() + "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"empresa\">Empresa :</label>"
                        + "<input  id=\"empresa\" name=\"empresa\" value=\" " + am.getEmpresa() + "\">"
                        + "</div>"
                        + "<div>"
                        + "<label for=\"direccionempresa\">Direccion Empresa :</label>"
                        + "<input  id=\"direccionempresa\" name=\"direccionempresa\" value=\" " + am.getDireccionempresa()+ "\">"
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
