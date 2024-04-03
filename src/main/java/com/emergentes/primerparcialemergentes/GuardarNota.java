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
@WebServlet(name = "GuardarNota", urlPatterns = {"/GuardarNota"})
public class GuardarNota extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession session = request.getSession();
    
    // Obtener el atributo lista de session
    ArrayList<String[]> lista;
    
    // Obtener la lista de la sesión
    if (session.getAttribute("lista") == null) {
        lista = new ArrayList<String[]>();
        session.setAttribute("lista", lista);
    } else {
        lista = (ArrayList<String[]>) session.getAttribute("lista");
    }

    // Obtener los parámetros del formulario
    String nombre = request.getParameter("estudiante");
    String primer_parcial = request.getParameter("primer_parcial");
    String segundo_parcial = request.getParameter("segundo_parcial");
    String examen_final = request.getParameter("examen_final");

    // Crear un nuevo array para almacenar los datos del estudiante
    String[] datosEstudiante = {nombre, primer_parcial, segundo_parcial, examen_final};
    
    lista.add(datosEstudiante);
    
    session.setAttribute("lista", lista);
    response.sendRedirect("index.jsp");
        
    }

   
}
