package com.emergentes.primerparcialemergentes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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

@WebServlet(name = "EliminarNota", urlPatterns = {"/EliminarNota"})
public class EliminarNota extends HttpServlet {

    @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("estudianteId");
        HttpSession session = request.getSession();
        ArrayList<String[]> lista;
        lista = new ArrayList<String[]>();
        lista = (ArrayList<String[]>) session.getAttribute("lista");

        for (int i = 0; i < lista.size(); i++) {
            String[] item = lista.get(i);
            if (item[0].equals(id)) {
                lista.remove(i);
                break;
            }
        }

        // Actualizar la lista en la sesion
        session.setAttribute("lista", lista);
        response.sendRedirect("index.jsp");

    }
}
