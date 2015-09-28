<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/FileCss.css">
<title>Pagina Di Login</title>
</head>
<body>


<div id="header">
	<h1>Pagina Login</h1>
</div>


<div id="contente1">

	<form method="post" action="login.do">
			<p>Username:<input type="text" name="username" value="${username}"/></p>
			<p>${mappaErroriLogin["username"]}</p>
			<p>Password:<input type="password" name="password"/></p>
			<p>${mappaErroriLogin["password"]}</p>
			<p><input type="submit" name="login" value="Login"/></p>
			${mappaErroriLogin["generico"]}
		</form>

</div>

<div id="footer">
	<h3>Sistema Informativo</h3>
</div>
</body>
</html>