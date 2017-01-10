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
	<table>
		<c:choose>
			<c:when test="${ingredients[0] != null}">

				<tr>
					<th>Nom</th>
					<th>Prix</th>
					<th>Quantité</th>
				</tr>
			</c:when>
			<c:otherwise>
			<p>Aucun ingrédients enregistrés</p>
			</c:otherwise>
		</c:choose>
		<c:forEach items="${ingredients}" var="ingredients">
			<form method="get" action='<c:url value="edit/${ingredients.id}"/>'>
				<tr>
					<td>${ingredients.nom}</td>
					<td>${ingredients.prix}</td>
					<td>${ingredients.quantite}</td>
					<td>
						<button type="submit">Modifier Ingrédient</button>
					</td>
				</tr>
			</form>
		</c:forEach>
	</table>
	<form method="get" action='<c:url value="add"/>'>
		<button type="submit">Ajouter Ingrédient</button>

	</form>

</body>
</html>