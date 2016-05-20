<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="adicionaCompra" method="post">
			Produto&nbsp;&nbsp;<input type="text" name="item"/><br /><br />
			Valor&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="preco"/><br /><br />
			<input type="submit" value="Adicionar">
		</form><br />
		
		<form action="menu" method="post">
			<input type="submit" value="Voltar" />
		</form>
</body>
</html>