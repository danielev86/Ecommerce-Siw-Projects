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
<link rel="stylesheet" type="text/css" href="CSS/FileCss.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ricerca Ordine</title>
</head>
<body>
<div id="header">
	<h1>Ricerca Ordine Cliente</h1>
</div>

<div id="content">
	<form method="post" action="ricercaOrdineCliente.do">
		<p>Inserisci il codice di un ordine</p>
		<p><input type="text" name="codice_ordine" value="${codice_ordine}"/>${mappaErroriOrdine["codice"]}</p>
		<p>${mappaErroriOrdine["varie"]}</p>
		<p><input type="submit" name="ricerca" value="Ricerca"/></p>
	
	</form>
	<a href="accesso.jsp"><button>Vai Alla Pagina Di Amministrazione</button></a>
</div>

<div id="footer">
	<h3>Sistema Informativo</h3>
</div>

</body>
</html>