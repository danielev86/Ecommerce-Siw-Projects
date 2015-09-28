<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.uniroma3.model.Amministratore"
    import="service.*"%>
<%
	Amministratore amministratore = (Amministratore) session.getAttribute("amministratore");
	boolean convalida;
	if(amministratore != null)
		convalida = true;
	else convalida = false;
	if(!convalida){
		out.clear();
		RequestDispatcher rd = application.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/FileCss.css">
<title>Dettaglio Cliente</title>
</head>
<body>
<div id="header">
	<h1>Informazioni Cliente</h1>
</div>

<div id="content">
	<p>ID:<b>${clienteInfo.id}</b></p>
	<p>NOME:<b>${clienteInfo.nome}</b></p>
	<p>COGNOME:<b>${clienteInfo.cognome}</b></p>
	<p>EMAIL:<b>${clienteInfo.email}</b></p>
	<p>INDIRIZZO:<b>${clienteInfo.indirizzo}</b></p>
	<p><a href="accesso.jsp"><button>Vai Alla Pagina Di Amministrazione</button></a></p>
</div>

<div id="footer">
	<h3>Sistema Informativo</h3>
</div>
</body>
</html>