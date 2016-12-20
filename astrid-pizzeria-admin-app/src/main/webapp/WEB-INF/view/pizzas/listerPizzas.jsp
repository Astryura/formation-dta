<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Tableau Pizzas</title>
</head>
<body>
<div class=”container”>
	<div class="row">
		<div class="col-md-2"><h1>Code</h1></div>
		<div class="col-md-2"><h1>Nom</h1></div>
		<div class="col-md-2"><h1>Prix</h1></div>
		<div class="col-md-2"><h1>Catégorie</h1></div>
		<div class="col-md-2"><h1>Modifier</h1></div>
		<div class="col-md-2"><h1>Supprimer</h1></div>
	</div>
<%  List<Pizza> list = (List<Pizza>) request.getAttribute("listPizzas"); 
	for(Pizza pizza: list){
		Integer id = pizza.getId();
		String code = pizza.getCode();
		String nom = pizza.getNom();
		Double prix = pizza.getPrix();
		String cat = pizza.getCatP();
%>
	<div class="row">
		<form method="post" action="edit">
			<input type="hidden" name="id" value="<%= id %>" />
			<div class="col-md-2"><input type="text" name="code" value="<%= code %>" readonly/></div>
			<div class="col-md-2"><input type="text" name="nom" value="<%= nom %>" readonly/></div>
			<div class="col-md-2"><input type="text" name="prix" value="<%= prix %>" readonly/></div>
			<div class="col-md-2"><input type="text" name="cat" value="<%= cat %>" readonly/></div>
			<div class="col-md-2"><input type="submit" value="Modifier"/></div>
		</form>
		<form method="post" action="delete">
			<input type="hidden" name="codePizza" value="<%= code %>"/>
			<div class="col-md-2"><input type="submit" value="Supprimer"/></div>
		</form>
	</div>
<%
	}
%>
</div>
</body>
</html>