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
<title>Ajouter Pizza</title>
<style>
.width {
	width: 100%;
}
</style>
</head>
<body>
	<div class=”container”>
	<%@include file="../navbar.jsp" %>
		<form class="form-horizontal" method="post" action="add">
			<fieldset>

				<!-- Form Name -->
				<legend>Ajouter une Pizza</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code :</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text"
							placeholder="Code de la Pizza" class="form-control input-md">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nom :</label>
					<div class="col-md-4">
						<input id="nom" name="nom" type="text"
							placeholder="Nom de la Pizza" class="form-control input-md">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prix">Prix :</label>
					<div class="col-md-4">
						<input id="prix" name="prix" type="text"
							placeholder="Prix de la Pizza" class="form-control input-md">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="cat">Catégorie :</label>
					<div class="col-md-4">
						<input id="cat" name="cat" type="text"
							placeholder="Catégorie de la Pizza" class="form-control input-md">

					</div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="img">Image :</label>
					<div class="col-md-4">
						<input id="img" name="img" type="file" class="form-control input-md">

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="add"></label>
					<div class="col-md-4">
						<input class="btn btn-default width" type="submit" value="Ajouter" />
					</div>
				</div>

			</fieldset>
		</form>


	</div>
</body>
</html>