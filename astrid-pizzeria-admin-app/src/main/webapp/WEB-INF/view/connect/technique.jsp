<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Technique</title>
</head>
<body>
	<div class=”container”>
	<%@include file="../navbar.jsp" %>
		<c:forEach var="log" items="${info}">
			<div class="row">
				<div class="col-md-6 col-md-offset-4">
					<h4>${log}</h4>
				</div>
			</div>
		</c:forEach>
		<div class="row">
			<div class="col-md-6 col-md-offset-4">
				<h4>${nbSession}</h4>
			</div>
		</div>
		<c:forEach var="listAdd" items="${listAdd}">
			<div class="row">
				<div class="col-md-6 col-md-offset-4">
					<h4>Pizza ajoutée le : ${listAdd.dateCreation}</h4>
					<h4>${listAdd.pizza.code},${listAdd.pizza.nom},${listAdd.pizza.prix},${listAdd.pizza.catP}</h4>
				</div>
			</div>
		</c:forEach>
		<c:forEach var="listUp" items="${listUp}">
			<div class="row">
				<div class="col-md-6 col-md-offset-4">
					<h4>Pizza modifiée le : ${listUp.dateUpdate}</h4>
					<h4>old : ${listUp.pizzaModifier.code},${listUp.pizzaModifier.nom},${listUp.pizzaModifier.prix},${listUp.pizzaModifier.catP}</h4>
					<h4>new : ${listUp.pizza.code},${listUp.pizza.nom},${listUp.pizza.prix},${listUp.pizza.catP}</h4>
				</div>
			</div>
		</c:forEach>
		<c:forEach var="listDel" items="${listDel}">
			<div class="row">
				<div class="col-md-6 col-md-offset-4">
					<h4>Pizza Supprimée le : ${listDel.dateDelete}</h4>
					<h4>${listDel.pizza.code},${listDel.pizza.nom},${listDel.pizza.prix},${listDel.pizza.catP}</h4>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>