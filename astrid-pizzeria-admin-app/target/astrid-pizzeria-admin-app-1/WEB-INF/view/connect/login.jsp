<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>


  <link rel="stylesheet" href="../otherCssJs/normalize.min.css">

  
      <link rel="stylesheet" href="../otherCssJs/style.css">

  
</head>

<body>
  <div class="login">
  <header class="header">
    <span class="text">Login</span>
    <span class="loader"></span>
  </header>
  <form class="form" action="login" method="post">  
    <input class="input" name="email" type="email" placeholder="Email">
    <input class="input" name="mdp" type="password" placeholder="Password">
    <button class="btn" type="submit"></button>
  </form>
</div>
</body>
</html>
