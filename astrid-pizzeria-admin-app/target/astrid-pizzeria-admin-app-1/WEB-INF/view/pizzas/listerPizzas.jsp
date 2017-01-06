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
		<%@include file="../navbar.jsp" %>
		
		<div class="row">
			<c:forEach var="pizza" items="${listPizzas}">
				<div class="col-md-3">
					<div class="thumbnail">
						<img style="height: 100px;" src="../Pizzas/${pizza.image}" />
						<div class="caption">
							<form method="post" action="editer">
							<input type="hidden" name="img" value="${pizza.image}" />
								<h3>
									<input
										class="panel" type="text" name="nom" value="${pizza.nom}"
										readonly />
								</h3>
								<p>
									<input type="hidden" name="id" value="${pizza.id}" /> <input
										class="panel" type="text" name="code" value="${pizza.code}"
										readonly />
								</p>
								<p>
									<input class="panel" type="text" name="prix"
										value="${pizza.prix}" readonly />
								</p>
								<p>
									<input class="panel" type="text" name="cat"
										value="${pizza.catP}" readonly />
								</p>
								<button class="btn btn-default width" type="submit">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
							</form>
							<form method="post" action="delete">
								<input type="hidden" name="codePizza" value="${pizza.code}" />
								<button class="btn btn-default width" type="submit">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</button>
							</form>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
</body>

</html>