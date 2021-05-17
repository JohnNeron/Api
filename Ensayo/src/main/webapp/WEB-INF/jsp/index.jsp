<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/formStyle.css">
<title>Productos Agregados</title>
</head>
<body>
	<nav>
		<ul class="topnav">
		  <li><a href="/agregar">Agregar Producto</a></li>
		  <li><a href="/agregarC">Agregar Categoria</a></li>
		  <li><a class="active" href="/">Ver Productos</a></li>
		  <li class="right"><a href="/editar">Editar</a></li>
		</ul>
	</nav>
	<h1>Productos Agregados</h1>
	 <div class="tbl-content">
		<table cellpadding="0" cellspacing="0" border="0">
	      	<th style="width: 250px"> Nombre</th>
			<th style="width: 250px"> Stock</th>
			<th style="width: 250px"> Precio</th>
			<th style="width: 250px"> Categoria</th>
			<c:forEach items="${productos}" var="p">
				<tbody id="myTable">
					<tr>
						<td>${p.nombre}</td>
						<td>${p.stock}</td>
						<td>${p.precio}</td>
						<td>${p.categoria.nombre}</td>
					</tr>
				</tbody>
			</c:forEach>	
	   	 </table>
	</div>
</body>
</html>