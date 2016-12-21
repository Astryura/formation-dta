<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Tableau Pizzas</title>
<style>
.width {
	width: 100%;
}
</style>
</head>
<body>
	<div class=”container”>
		<div class="row navbar panel-body panel-primary">
			<div class="col-md-2">
				<h1>Code</h1>
			</div>
			<div class="col-md-2">
				<h1>Nom</h1>
			</div>
			<div class="col-md-2">
				<h1>Prix</h1>
			</div>
			<div class="col-md-2">
				<h1>Catégorie</h1>
			</div>
			<div class="col-md-2">
				<h1>Modifier</h1>
			</div>
			<div class="col-md-2">
				<h1>Supprimer</h1>
			</div>
		</div>
		<c:forEach var="pizza" items="${listPizzas}">

			<div class="row navbar panel-body">
				<form method="post" action="edit">
					<input type="hidden" name="id" value="${pizza.id }" />
					<div class="col-md-2">
						<input class="panel" type="text" name="code" value="${pizza.code}"
							readonly />
					</div>
					<div class="col-md-2">
						<input class="panel" type="text" name="nom" value="${pizza.nom}"
							readonly />
					</div>
					<div class="col-md-2">
						<input class="panel" type="text" name="prix" value="${pizza.prix}"
							readonly />
					</div>
					<div class="col-md-2">
						<input class="panel" type="text" name="cat" value="${pizza.catP}"
							readonly />
					</div>
					<div class="col-md-2">
						<button class="btn btn-default width" type="submit">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
					</div>
				</form>
				<form method="post" action="delete">
					<input type="hidden" name="codePizza" value="${pizza.code}" />
					<div class="col-md-2">
						<button class="btn btn-default width" type="submit">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						</button>
					</div>
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>