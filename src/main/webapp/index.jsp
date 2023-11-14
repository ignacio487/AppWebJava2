<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Menu</title>
</head>
<body>
<h1 class="encabezado"> Menú Principal Usuarios</h1>
<br>
<form action="registroUsuario" method="post">
    <div class="inputs">
        <input name="nombre" type="text" placeholder="Nombre">
        <input name="edad" type="text" placeholder="Edad">
        <input name="rut" type="text" placeholder="Rut">
    </div>
    <input type="submit" value="Registrar Usuario">
</form>
</body>
</html>