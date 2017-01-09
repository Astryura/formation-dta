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
		<form method="post" action="edit">
			<table>
				<tr>
					<td><input name="id" id="id" value="${ingredients.id}"
						type="hidden" readonly /></td>
					<td><input name="nom" id="nom" value="${ingredients.nom}"
						type="text" readonly /></td>
					<td><input name="prix" id="prix" value="${ingredients.prix}"
						type="text" readonly /></td>
					<td><input name="quantite" id="quantite"
						value="${ingredients.quantite}" type="text" readonly /></td>

					<td>
						<button type="submit">Modifier Ingrédient</button>
					</td>
				</tr>
			</table>
		</form>
	</c:forEach>
	<form method="get" action="add">
		<button type="submit">Ajouter Ingrédient</button>

	</form>

</body>
</html>