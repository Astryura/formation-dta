<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Technique</title>
</head>
<body>
	<div class=”container”>
		<c:forEach var="log" items="${info}">
			<div class="row">
				<div class="col-md-6 col-md-offset-4">
					<h4>${log}</h4>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>