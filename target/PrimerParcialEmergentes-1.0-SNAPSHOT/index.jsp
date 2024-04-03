<%-- 
    Document   : index
    Created on : 2 abr. de 2024, 18:59:55
    Author     : JHOMARA
--%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%
    ArrayList<String[]> lista;
    if (session.getAttribute("lista") == null) {
        lista = new ArrayList<String[]>();
        session.setAttribute("lista", lista);
    } else {
        lista = (ArrayList<String[]>) session.getAttribute("lista");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    
    <fieldset>
        <h3>PRIMER PARCIAL</h3>
        <p><strong>Nombre:</strong> Jhomara Quecaña Zamora</p>
        <p><strong>Carnet:</strong> 10088531</p>
    </fieldset> 
    <br>
    <h2 style="text-align: center;">Registro de Calificaciones</h2>
   
    <a href="VistaAgregarNota">Nuevo</a>
    <br>    <br>

    <% if (lista != null && !lista.isEmpty()) { %>
    <table border="1">
            <tr>
                <th>Estudiante</th>
                <th>Primer Parcial</th>
                <th>Segundo Parcial</th>
                <th>Examen Final</th>
                <th>Acciones</th>
            </tr>
            <%
                Iterator<String[]> iterator = lista.iterator();
                while (iterator.hasNext()) {
                    String[] estudiante = iterator.next();
            %>
            <tr>
                <td><%= estudiante[0]%></td>
                <td><%= estudiante[1]%></td>
                <td><%= estudiante[2]%></td>
                <td><%= estudiante[3]%></td>
                <td>
                    <form method="get" action="VistaEditarNota">
                        <input type="hidden" name="estudianteId" value="<%= estudiante[0]%>">
                        <input type="submit" value="Editar">
                    </form>
                    <form method="post" action="EliminarNota">
                        <input type="hidden" name="estudianteId" value="<%= estudiante[0]%>">
                        <input type="submit" value="Eliminar">
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    <% } else { %>
    <p>No hay estudiantes en la lista.</p>
    <% } %>
</body>
</html>
