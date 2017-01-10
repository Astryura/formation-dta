<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Logs</title>
</head>
<body>
	<table>
		<c:choose>
			<c:when test="${performances[0] != null}">

				<tr>
					<th>Service</th>
					<th>Date</th>
					<th>Temps d'Execution</th>
				</tr>
			</c:when>
			<c:otherwise>
			<p>Aucun ingrédients enregistrés</p>
			</c:otherwise>
		</c:choose>
		<c:forEach items="${performances}" var="performances">
			<form method="get" action='<c:url value="edit/${performances.id}"/>'>
				<tr>
					<td>${performances.service}</td>
					<td>${performances.date}</td>
					<td>${performances.tempsExecution}</td>
				</tr>
			</form>
		</c:forEach>
	</table>
	

</body>
</html>