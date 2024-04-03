/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.primerparcialemergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JHOMARA
 */
@WebServlet(name = "VistaAgregarNota", urlPatterns = {"/VistaAgregarNota"})
public class VistaAgregarNota extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
            out.println("<head>");
            out.println("<title>Agregar Nota</title>");
            out.println("</head>");
            out.println("<body>"); 
            out.println("<h1>Registro de Calificaciones</h1>");
        out.println("<form action=\"GuardarNota\" method=\"post\">\n"
                + "            Nombre del estudiantes: <input type=\"text\" name=\"estudiante\">\n"
                + "            <br><br>\n"
                + "            Primer Parcial(sobre 30 pts): <input type=\"number\" name=\"primer_parcial\">\n"
                + "            <br><br>\n"
                + "            Segundo Parcial(sobre 30 pts): <input type=\"number\" name=\"segundo_parcial\">\n"
                + "            <br><br>\n"
                + "            Examen Final (sobre 40 pts): <input type=\"number\" name=\"examen_final\">\n"
                + "            <br><br>\n"
                + "            <input type=\"submit\" value=\"Enviar\">\n"
                + "        </form>");
         out.println("</body>");
            out.println("</html>");
    }

}
