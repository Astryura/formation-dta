function list() {
	$.get(
			"http://localhost:8080/astrid-pizzeria-admin-app-1/api/rest/clients",
			function(data) {
				console.log(data);
				var a =0;
				var str = "<div id=\"wrapper\">"
					+ "<div id=\"head\" class=\"row\">"
					+ "<div class=\"col-md-2\">Id</div>"
					+ "<div class=\"col-md-2\">Nom</div>"
					+ "<div class=\"col-md-2\">Prénom</div>"
					+ "<div class=\"col-md-4\">Email</div>"
					+ "<div class=\"col-md-2\">Modifier</div></div><div class=\"row\">";
				$(jQuery.parseJSON(JSON.stringify(data)))
				.each(
						function() {
							var id = this.id;
							var nom = this.nom;
							var prenom = this.prenom;
							var email = this.email;
							var motDePasse = this.motDePasse;
							a++;
							str += "<div class=\"col-md-2\"><input class=\"form-control width\" type=\"text\" name=\"id\" id=\"id"+a+"\" value=\"" + id + "\" readonly /></div><div class=\"col-md-2\">"
							+ "<input class=\"form-control width\" type=\"text\" name=\"nom\" id=\"nom"+a+"\" value=\"" + nom + "\" /></div><div class=\"col-md-2\">"
							+ "<input class=\"form-control width\" type=\"text\" name=\"prenom\" id=\"prenom"+a+"\" value=\"" + prenom + "\" />"
							+ "</div><div class=\"col-md-4\"><input class=\"form-control width\" type=\"text\" name=\"email\" id=\"email"+a+"\" value=\"" + email + "\" />"
							+ "</div><div class=\"col-md-2\"><button id=\"modifier"+a+"\" class=\"btn btn-default width\" data-id=\"" + a + "\">Modifier</button></div>";
						});
				str += "</div></div>";
				$("#result").html(str);
				console.log("$(#modifier)");
				for(var i=1;i<=a;i++){
					$("#modifier"+i).click(function(data) {
						var j = data.target.getAttribute("data-id");
						var id = $("#id"+j).val();
						var nom = $("#nom"+j).val();
						var prenom = $("#prenom"+j).val();
						var email = $("#email"+j).val();
						var mdp = $("#motDePasse"+j).val();
						var data = {
								id : id,
								nom : nom,
								prenom : prenom,
								email : email,
								motDePasse : mdp
						};
						$.ajax({
							url : "http://localhost:8080/astrid-pizzeria-admin-app-1/api/rest/clients/"+ id + "",
							type : 'PUT',
							data : JSON.stringify(data),
							contentType : 'application/json; charset=utf-8',
							dataType : 'json',
							success : function(msg) {
								list();
							}
						});

					});
				}
			});
}
$(function() {
	console.log("ready!");
	list();
	$("#add")
	.click(
			function() {
				var nom = $("#nomA").val();
				var prenom = $("#prenomA").val();
				var email = $("#emailA").val();
				var mdp = $("#motDePasseA").val();
				var data = {
						nom : nom,
						prenom : prenom,
						email : email,
						motDePasse : mdp
				};
				$
				.ajax({
					url : "http://localhost:8080/astrid-pizzeria-admin-app-1/api/rest/clients",
					type : 'POST',
					data : JSON.stringify(data),
					contentType : 'application/json; charset=utf-8',
					dataType : 'json',
					success : function(msg) {
						list();
					}
				});

			});
});