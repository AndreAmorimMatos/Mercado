<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alterar Lista</title>
	</head>	
<body>
	<form action="alteraMercado" method="post">
		Código <input type="text" name="cod_lista" value="${lista.cod_lista}" /><br /><br />
		Item &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="item" value="${lista.item}" /><br /><br />
		Preco &nbsp;&nbsp;<input type="text" name="preco" value="${lista.preco}" /><br /><br />
		<input type="submit" value="Alterar" />
	</form>
	</br>
	<form action="listar" method="post">
		<input type="submit" value="Voltar" />
	</form>
</body>
</html>