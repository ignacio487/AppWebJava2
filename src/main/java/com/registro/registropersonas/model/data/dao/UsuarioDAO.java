package com.registro.registropersonas.model.data.dao;

import com.registro.registropersonas.model.Usuario;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class UsuarioDAO {
    public boolean registrarUsuario (Usuario usuario, DSLContext query){
        String nombre=usuario.getNombre();
        int edad=usuario.getEdad();
        String rut=usuario.getRut();
        Table usuarioTabla=table(name("usuario-paginaweb"));
        Field[] columnas=usuarioTabla.fields(
                "nombre",
                "edad",
                "rut"
        );
        int results=0;
        try {
            results = query.insertInto(usuarioTabla, columnas[0], columnas[1], columnas[2])
                    .values(nombre, edad, rut)
                    .execute();
        } catch (Exception e) {

            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return results==1;
    }
    List<Usuario> listaUsuarios = obtenerListaUsuarios();
    private List<Usuario> obtenerListaUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("Juan", 25, "123456789"));
        listaUsuarios.add(new Usuario("María", 30, "987654321"));
        return listaUsuarios;
    }
}