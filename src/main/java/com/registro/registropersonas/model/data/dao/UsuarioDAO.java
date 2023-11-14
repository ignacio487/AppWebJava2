package com.registro.registropersonas.model.data.dao;

import com.registro.registropersonas.model.Usuario;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import java.sql.SQLIntegrityConstraintViolationException;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class UsuarioDAO {
    public boolean registrarUsuario(DSLContext query, Usuario usuario){
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
            // Código adicional a realizar en caso de éxito en la realizacion de la consulta

        } catch (Exception e) {
            // Manejo de la excepción ocurrida durante la realizacion de la consulta

            // Por ejemplo, imprimir el mensaje de error
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());

            // O realizar alguna otra acción en caso de error
        }
        return results==1;
    }
}