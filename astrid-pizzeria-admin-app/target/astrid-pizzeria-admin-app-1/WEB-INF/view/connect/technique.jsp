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
<link rel="stylesheet" href="../otherCssJs/table.css">
</head>
<body>
	<div class=”container”>
		<%@include file="../navbar.jsp"%>
		<div id="wrapper">
			<div id="head" class="row">
				<div class="col-md-2">Liste des actions :</div>
				<div class="col-md-1">Nombre de sessions ouvertes :</div>
				<div class="col-md-3">Pizzas ajoutées :</div>
				<div class="col-md-3">Pizzas modifiées :</div>
				<div class="col-md-3">Pizzas Supprimées :</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<c:forEach var="log" items="${info}">
						<p>${log}</p>
					</c:forEach>
				</div>
				<div class="col-md-1">
					<p>${nbSession}</p>
				</div>
				<div class="col-md-3">
					<c:forEach var="listAdd" items="${listAdd}">
						<h4>Date : ${listAdd.dateCreation}</h4>
						<p>${listAdd.pizza.code},${listAdd.pizza.nom},${listAdd.pizza.prix},${listAdd.pizza.catP}</p>
					</c:forEach>
				</div>
				<div class="col-md-3">
					<c:forEach var="listUp" items="${listUp}">
						<h4>Date : ${listUp.dateUpdate}</h4>
						<p>old :
							${listUp.pizzaModifier.code},${listUp.pizzaModifier.nom},${listUp.pizzaModifier.prix},${listUp.pizzaModifier.catP}</p>
						<p>new :
							${listUp.pizza.code},${listUp.pizza.nom},${listUp.pizza.prix},${listUp.pizza.catP}</p>
					</c:forEach>
				</div>
				<div class="col-md-3">
					<c:forEach var="listDel" items="${listDel}">
						<h4>Date : ${listDel.dateDelete}</h4>
						<p>${listDel.pizza.code},${listDel.pizza.nom},${listDel.pizza.prix},${listDel.pizza.catP}</p>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>