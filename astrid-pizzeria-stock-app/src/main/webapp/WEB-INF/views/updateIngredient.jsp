<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="${ingredients.id}" modelAttribute="ingredient">
		<table>
			<tr>
			<form:input path="id" type="hidden"/>
				<td>Nom</td>
				<td><form:input path="nom" type="text" /></td>
			</tr>
			<tr>
				<td>Prix</td>
				<td><form:input path="prix" type="text" /></td>
			</tr>
			<tr>
				<td>Quantité</td>
				<td><form:input path="quantite" type="text" /></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Modifier Ingrédient</button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>