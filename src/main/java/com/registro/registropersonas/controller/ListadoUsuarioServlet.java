package com.registro.registropersonas.controller;

import com.registro.registropersonas.model.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listadoUsuario")
public class ListadoUsuarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Lógica para obtener la lista de usuarios (puedes adaptar esto según tus necesidades)
        List<Usuario> listaUsuarios = obtenerListaUsuarios();

        // Establecer el tipo de contenido de la respuesta
        response.setContentType("text/html");

        // Obtener el escritor de la respuesta
        PrintWriter out = response.getWriter();

        // Escribir el contenido de la página HTML de respuesta
        out.println("<html>");
        out.println("<head><title>Listado de Usuarios</title></head>");
        out.println("<body>");
        out.println("<h2>Listado de Usuarios</h2>");

        // Iterar sobre la lista de usuarios y mostrar la información
        for (Usuario usuario : listaUsuarios) {
            out.println("<p>Nombre: " + usuario.getNombre() + "</p>");
            out.println("<p>Edad: " + usuario.getEdad() + "</p>");
            out.println("<p>RUT: " + usuario.getRut() + "</p>");
            out.println("<hr>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    private List<Usuario> obtenerListaUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("Juan", 25, "123456789"));
        listaUsuarios.add(new Usuario("María", 30, "987654321"));
        return listaUsuarios;
    }
}
