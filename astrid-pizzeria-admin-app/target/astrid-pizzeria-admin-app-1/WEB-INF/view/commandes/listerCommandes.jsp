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
<title>Tableau Commandes</title>
<link rel="stylesheet" href="../otherCssJs/table.css">
</head>

<body>
	<div class=”container”>
		<%@include file="../navbar.jsp"%>
		<div id="wrapper">
			<div id="head" class="row">
				<div class="col-md-2">Numéro Commande</div>
				<div class="col-md-2">Statut</div>
				<div class="col-md-2">Date Commande</div>
				<div class="col-md-2">Client</div>
				<div class="col-md-2">Livreur</div>
				<div class="col-md-2">Pizzas</div>
			</div>
			<div class="row">
				<c:forEach var="commande" items="${listCommandes}">
					<div class="col-md-2">${commande.numeroCommande}</div>
					<div class="col-md-2">
						<form method="post" action="listCommande">
						<input type="hidden" name="numero" value="${commande.numeroCommande}" />
							<button type="submit" class="btn btn-default width">
								<c:choose>
									<c:when test="${commande.statut == 0}">
									Non-traitée
							    </c:when>
									<c:otherwise>
							       Expédiée
							    </c:otherwise>
								</c:choose>
							</button>
						</form>
					</div>
					<div class="col-md-2">${commande.dateCommande}</div>
					<div class="col-md-2">${commande.client.prenom}
						${commande.client.nom}</div>
					<div class="col-md-2">${commande.livreur.prenom}
						${commande.livreur.nom}</div>
					<div class="col-md-2">
						<c:forEach var="pizza" items="${commande.pizzas}">
					${pizza.nom}<br>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>

</html>