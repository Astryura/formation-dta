<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
</head>
<body>
	<div class=”container”>
		<form class="form-horizontal" action="login" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Connectez-vous :</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email</label>
					<div class="col-md-4">
						<input id="email" name="email" type="text"
							placeholder="Votre email" class="form-control input-md">

					</div>
				</div>
				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="mdp">Mot de
						passe</label>
					<div class="col-md-4">
						<input id="mdp" name="mdp" type="password"
							placeholder="Votre mot de passe" class="form-control input-md">

					</div>
				</div>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="valider"></label>
					<div class="col-md-4">
						<button id="valider" name="valider" class="btn btn-info">Valider</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>

</body>
</html>