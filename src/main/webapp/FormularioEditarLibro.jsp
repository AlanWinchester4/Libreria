<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="es">
<%@ page import= "java.util.List"%>
<%@ page import= "beans.Libro"%>
<%@ page import= "dbhHelpers.DataBaseException"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario Editar Libro</title>
		<LINK rel="stylesheet" type="text/css" href="css/vista.css"/>
	</head>
	<body>
		<h1>Formulario Editar Libro</h1>
		<form action="EditarLibro.do" method = "GET">
			<c:if test="${not empty getNum_lib}">
				<input type="hidden" name="IdLibro" id="ID" value="${getNum_lib}"/>
			</c:if>
			<c:if test="${not empty getisbn_lib}">
			<P><labeL for="ISBN">ISBN:</label>
				<input type="text" name="ISBNLibro" id="ISBN" value="${getisbn_lib}"/></p>
			</c:if>
			<c:if test="${not empty gettit_lib}">
				<P><label for="Titulo">Titulo:</label>
				<input type="text" name="TitLibro" id="Titulo"value="${gettit_lib}"/></p>
			</c:if>
			<c:if test="${not empty getcat_lib}">	
				<P><label for="Categoria">Categoria:</label>
				<input type="text" name="CatLibro" id="Categoria"value="${getcat_lib}"/></p>
			</c:if>
			<c:if test="${not empty getpre_lib}">	
				<P><label for="Precio">Precio:</label>
				<input type="text" name="PreLibro" id="Precio"value="${getpre_lib}"/></p>
			</c:if>
			
			<input type="submit" value="submit"/>
			
		</form>
	</body>
</html>