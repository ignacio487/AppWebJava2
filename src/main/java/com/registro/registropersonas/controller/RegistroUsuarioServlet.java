package com.registro.registropersonas.controller;

import com.registro.registropersonas.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistroUsuarioServlet", value = "/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/registroUsuario.jsp");
        requestDispatcher.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        System.out.println("ssss");
        String nombre=request.getParameter("nombre");
        int edad= Integer.parseInt(
                request.getParameter("edad").isEmpty()?"0":request.getParameter("edad"));

        String rut=request.getParameter("rut");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");

        if(!nombre.isEmpty() && edad!=0 && !rut.isEmpty()){
            Usuario usuario=new Usuario(nombre,edad,rut);
            if(usuario.registrarUsuario()){
                request.setAttribute("status","El registro se realizo correctamente");
            }else{
                request.setAttribute("status","El rut ingresado ya se encuentra registrado");
            }

        }else{
            request.setAttribute("status","Complete todos los campos");
        }
        requestDispatcher.forward(request,response);
    }
}