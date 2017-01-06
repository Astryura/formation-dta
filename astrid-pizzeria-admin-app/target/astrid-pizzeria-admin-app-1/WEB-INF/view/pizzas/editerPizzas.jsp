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
<title>Modifier Pizza</title>
<style>
.width {
	width: 100%;
}
</style>
</head>
<body>
	<div class=”container”>
	<%@include file="../navbar.jsp" %>
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
				<h1>Image</h1>
			</div>
			<div class="col-md-2">
				<h1>Modifier</h1>
			</div>
		</div>
		<div class="row navbar  panel-body">
			<form method="get" action="editer">
				<input type="hidden" name="codePizza" value="${pizza.code}" readonly />
				<input type="hidden" name="id" value="${pizza.id}" readonly />
				<div class="col-md-2">
					<input class="form-control width" type="text" name="code"
						value="${pizza.code}" />
				</div>
				<div class="col-md-2">
					<input class="form-control width" type="text" name="nom"
						value="${pizza.nom}" />
				</div>
				<div class="col-md-2">
					<input class="form-control width" type="text" name="prix"
						value="${pizza.prix}" />
				</div>
				<div class="col-md-2">
					<input class="form-control width" type="text" name="cat"
						value="${pizza.catP}" />
				</div>
				<div class="col-md-2">
					<input id="img" name="img" type="file"
						class="form-control input-md" value="${pizza.image}">
				</div>
				<div class="col-md-2">
					<input class="btn btn-default width" type="submit" value="Valider" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>