/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.primerparcialemergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JHOMARA
 */
@WebServlet(name = "ActualizarEstudiante", urlPatterns = {"/ActualizarEstudiante"})
public class ActualizarEstudiante extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<String[]> lista;
        lista = new ArrayList<String[]>();
        lista = (ArrayList<String[]>) session.getAttribute("lista");

        String nombre = request.getParameter("estudiante");
        String primer_parcial = request.getParameter("primer_parcial");
        String segundo_parcial = request.getParameter("segundo_parcial");
        String examen_final = request.getParameter("examen_final");

        String[] datosEstudiante = {nombre, primer_parcial, segundo_parcial, examen_final};

        String id = request.getParameter("id");

        // actualizar los datos de la lista por id
        for (int i = 0; i < lista.size(); i++) {
            String[] item = lista.get(i);
            if (item[0].equals(id)) {
                lista.set(i, datosEstudiante);
                break;
            }
        }

        session.setAttribute("lista", lista);
        response.sendRedirect("index.jsp");

    }
}
