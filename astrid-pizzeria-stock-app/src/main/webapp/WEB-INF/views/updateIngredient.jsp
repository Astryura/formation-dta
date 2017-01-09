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
	<form method="get">
		<table>
			<tr>
				<td>Id</td>
				<td><input name="id" id="id" type="text" value="${ingredient.id}" readonly/></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><input name="nom" id="nom" type="text" value="${ingredient.nom}" /></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><input name="prix" id="prix" type="text" value="${ingredient.prix}" /></td>
			</tr>
			<tr>
				<td>Quantité</td>
				<td><input name="quantite" id="quantite" type="text" value="${ingredient.quantite}" /></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Modifier Ingrédient</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>