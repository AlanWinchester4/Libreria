<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page import= "java.util.List"%>
<%@ page import= "beans.Libro"%>
<%@ page import= "dbhHelpers.DataBaseException"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
<title>Insert title here</title>
<LINK rel="stylesheet" type="text/css" href="css/vista.css"/>
</head>
<body>
<form action="ControladorLibros.do" method = "Post">
	<select name= "categoria">
	<option value= "seleccionar">Seleccionar</option>
			<c:forEach var = "cat" items="${listaDeCategorias}">
				<option value="${cat.getNum_cat()}">${cat.getNom_cat()}</option>
			</c:forEach>
	</select>
	<INPUT type="submit" value="Filtrar"/>
</form>
<br/>
	<DIV class="div-tabla">
		<h1>Tabla de Libros</h1>
		<table class = "content-table">
			<thead>
				<tr>
					<th >Numero de Libro</th>
					<th class="col">ISBN</th>
					<th>Titulo de Libro</th>
					<th>Categoria</th>
					<th class="col">Precio</th>
					<th class="col">Opciones</th>
				</tr>
			</thead>	
				<TBODY>
					<c:forEach var="L" items="${listaDeLibros}">
								<TR>
									<td class = "col-num">${L.getNum_lib()}</td>
									<td class ="active-row">${L.getisbn_lib()}</td>
									<td>${L.gettit_lib()}</td>
									<td class = "col-cat">${L.getCategoria().getNom_cat()}</td>
									<td class = "col-pre">${L.getpre_lib()}</td>
									<td>
										<a href="BorrarLibro.do?id=${L.getNum_lib()}">Borrar</a>
										<a href="MostrarEditarLibro.do?id=${L.getNum_lib()}">Editar</a>
									</td>
								</TR>
					</c:forEach>			
				</TBODY>
		</table>
	</DIV>
<a id=link href="FormularioAltaLibro.jsp">Insertar Nuevo Libro</a>
</body>
</html>