<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${ingredients}" var="ingredients">
		<form method="get" action='<c:url value="edit/${ingredients.id}"/>'>
			<table>
				<tr>
					<td>${ingredients.nom}</td>
					<td>${ingredients.prix}</td>
					<td>${ingredients.quantite}</td>
					<td>
						<button type="submit">Modifier Ingrédient</button>
					</td>
				</tr>
			</table>
		</form>
	</c:forEach>
	<form method="get" action='<c:url value="add"/>'>
		<button type="submit">Ajouter Ingrédient</button>

	</form>

</body>
</html>