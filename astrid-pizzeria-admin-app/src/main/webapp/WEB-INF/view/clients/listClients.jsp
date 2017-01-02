<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<script src="../otherCssJs/jquery.min.js" type="text/javascript"></script>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Tableau Clients</title>
<script>
	$(function() {
		console.log("ready!");
		$
				.get(
						"http://localhost:8080/astrid-pizzeria-admin-app-1/api/rest/clients",
						function(data) {
							//$( "#result" ).html( data );
							console.log(data);
							var str = "<table><tr><th>Id</th><th>Nom</th><th>Prénom</th><th>Email</th><th>Mot de Passe</th></tr>";
							$(jQuery.parseJSON(JSON.stringify(data))).each(
									function() {
										var id = this.id;
										var nom = this.nom;
										var prenom = this.prenom;
										var email = this.email;
										var motDePasse = this.motDePasse;
										str += "<tr><td>" + id + "</td><td>"
												+ nom + "</td><td>" + prenom
												+ "</td><td>" + email
												+ "</td><td>" + motDePasse
												+ "</td></tr>";
									});
							str += "</table>";
							$("#result").html(str);
						});
	});
</script>
</head>

<body>
	<div class=”container”>
		<%@include file="../navbar.jsp"%>
		<div id="result"></div>
	</div>

</body>
</html>