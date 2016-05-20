<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Mercado</title>
</head>
	<body>
		<table>
			<tr>
				<td>Código</td>
				<td>Produto</td>
				<td>Valor</td>
			</tr>
			
			<c:forEach items="${linhas}" var="linhas">
				<tr>
					<td>${linhas.cod_lista}</td>
					<td>${linhas.item}</td>
					<td>${linhas.preco}</td>
					
					<td>
						<a href="remove?cod_lista=${linhas.cod_lista}">Remover</a>
					</td>
					
					<td>
						<a href="mostraAlteracao?cod_lista=${linhas.cod_lista}">Alterar</a>
					</td>					
				</tr>
			</c:forEach>
		</table>
		</br>
	
		<form action="menu" method="post">
			<input type="submit" value="Voltar" />
		</form>
		
	</body>
</html>