<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/registrar.css">
	<script src="js/form.js"></script>
<title>Producto Nuevo</title>
</head>
<body>
	<div class="wrapper">
        <h1>Nuevo Producto</h1>
        <form:form action="/registrarProducto" method="POST" modelAttribute="producto">
          <p>Nombre del producto: </p>
         <form:input path="nombre"/>
		 <form:errors path="nombre"></form:errors>
          <p>Stock: </p>
          <form:input path="stock"/>
		  <form:errors path="stock"></form:errors>
		  <p>Precio: </p>
          <form:input path="precio"/>
		  <form:errors path="precio"></form:errors>
		  <p>Categoria: </p>
			<form:select path="categoria" cssClass="select">
				<form:options items="${categorias}" itemValue="id" itemLabel="nombre"/>
			</form:select>
          <input type="submit" class="submit button3" value="Agregar">
          </form:form><br>
          <form:form action="/" method="GET">
          <input type="submit" class="submit button3" value="Volver">
          </form:form>
      </div>
</body>
</html>