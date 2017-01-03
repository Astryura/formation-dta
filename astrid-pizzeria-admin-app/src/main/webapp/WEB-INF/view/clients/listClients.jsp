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
<link rel="stylesheet" href="../otherCssJs/table.css">
<title>Tableau Clients</title>
<script src="../otherCssJs/script.js">
	
</script>
</head>

<body>
	<div class=”container”>
		<%@include file="../navbar.jsp"%>
		<div id="result"></div>
		<div class="form-horizontal">
			<fieldset>

				<!-- Form Name -->
				<legend>Ajouter Client</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nomA">Nom</label>
					<div class="col-md-4">
						<input id="nomA" name="nomA" type="text" placeholder="Nom"
							class="form-control input-md">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prenomA">Prénom</label>
					<div class="col-md-4">
						<input id="prenomA" name="prenomA" type="text"
							placeholder="prénom" class="form-control input-md">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="emailA">Email</label>
					<div class="col-md-4">
						<input id="emailA" name="emailA" type="text" placeholder="email"
							class="form-control input-md">

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="motDePasseA">Mot
						de Passe</label>
					<div class="col-md-4">
						<input id="motDePasseA" name="motDePasseA" type="password"
							placeholder="Mot de passe" class="form-control input-md">

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="add"></label>
					<div class="col-md-4">
						<button id="add" name="add" class="btn btn-primary">Ajouter</button>
					</div>
				</div>

			</fieldset>
		</div>
		<span></span>
	</div>

</body>
</html>