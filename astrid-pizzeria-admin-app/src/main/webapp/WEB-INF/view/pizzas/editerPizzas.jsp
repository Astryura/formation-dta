<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Modifier Pizzas</title>
</head>
<body>
<div class=”container”>
	<div class="row">
		<div class="col-md-2"><h1>Id</h1></div>
		<div class="col-md-2"><h1>Code</h1></div>
		<div class="col-md-2"><h1>Nom</h1></div>
		<div class="col-md-2"><h1>Prix</h1></div>
		<div class="col-md-2"><h1>Catégorie</h1></div>
		<div class="col-md-2"><h1>Modifier</h1></div>
	</div>
<%  Pizza pizza = (Pizza) request.getAttribute("pizza"); 
		Integer id = pizza.getId();
		String code = pizza.getCode();
		String nom = pizza.getNom();
		Double prix = pizza.getPrix();
		String cat = pizza.getCatP();
%>
	<div class="row">
		<form method="get" action="edit">
			<input type="hidden" name="codePizza" value="<%= code %>" readonly />
			<div class="col-md-2"><input type="text" name="id" value="<%= id %>" readonly /></div>
			<div class="col-md-2"><input type="text" name="code" value="<%= code %>" /></div>
			<div class="col-md-2"><input type="text" name="nom" value="<%= nom %>" /></div>
			<div class="col-md-2"><input type="text" name="prix" value="<%= prix %>" /></div>
			<div class="col-md-2"><input type="text" name="cat" value="<%= cat %>" /></div>
			<div class="col-md-2"><input type="submit" value="Valider"/></div>
		</form>
	</div>

</div>
</body>
</html>