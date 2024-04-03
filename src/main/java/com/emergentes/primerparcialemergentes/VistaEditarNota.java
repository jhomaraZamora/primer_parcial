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

@WebServlet(name = "VistaEditarNota", urlPatterns = {"/VistaEditarNota"})
public class VistaEditarNota extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("estudianteId");
        HttpSession session = request.getSession();
        ArrayList<String[]> lista;
        lista = new ArrayList<String[]>();
        lista = (ArrayList<String[]>) session.getAttribute("lista");

        // obtener los datos del estudiante de la lista para ponerlos en el formulario
        String[] estudiante = null;
        for (int i = 0; i < lista.size(); i++) {
            String[] item = lista.get(i);
            if (item[0].equals(id)) {
                estudiante = item;
                break;
            }
        }

        // generar formulario
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Editar Estudiante</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Editar Estudiante</h1>");
            out.println("<form action='ActualizarEstudiante' method='post'>");
            out.println("<input type='hidden' name='id' value='" + id + "'>");
            out.println("<label>Nombre:</label>");
            out.println("<input type='text' name='estudiante' value='" + estudiante[0] + "'><br>");
            out.println("<label>Primer Parcial:</label>");
            out.println("<input type='text' name='primer_parcial' value='" + estudiante[1] + "'><br>");
            out.println("<label>Segundo parcial:</label>");
            out.println("<input type='text' name='segundo_parcial' value='" + estudiante[2] + "'><br>");
            out.println("<label>Examen final:</label>");
            out.println("<input type='text' name='examen_final' value='" + estudiante[3] + "'><br>");
            out.println("<input type='submit' value='Actualizar'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }
}