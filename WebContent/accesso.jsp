<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.uniroma3.model.*"
    import="service.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
 <%
 	Cliente cliente = (Cliente) session.getAttribute("cliente");
 	Amministratore amministratore =(Amministratore) session.getAttribute("amministratore");
 	boolean convalida;
 	if(cliente !=null || amministratore !=null)
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
<title>Pagina Amministrazione</title>
</head>
<body>
<div id="header">
	<h1>Pagina Amministrazione</h1>
</div>

<div id="content">
	<c:if test="${cliente==null}">
		<p>Buongiorno amministratore!</p>
		<p>Puoi fare le seguenti operazioni:</p>
		<ol>
			<li><a href="inserisciProdotto.jsp">Inserisci Articolo Nel Catalogo</a></li>
			<li><a href="informazioniCliente.jsp">Recupera Informazioni Cliente</a></li>
			<li><a href="evasioneOrdine.jsp">Evasione Ordine</a></li>
		</ol>
		<form action="logout.do" method = "post">
			<input type ="submit" name = "logout" value = "Logout"/>
		</form>
	</c:if>
	<c:if test="${amministratore==null}">
		<p>Buongiorno ${cliente.nome} ${cliente.cognome}!</p>
		<p>Puoi fare le seguenti operazioni:</p>
		<ol>
			<li><a href="effettuaOrdine.jsp">Effettua Ordine</a></li>
			<li><a href="consultaOrdini.jsp">Consulta i tuoi Ordini</a></li>
			
		</ol>
		<form action="logout.do" method = "post">
			<input type ="submit" name = "logout" value = "Logout"/>
		</form>
	</c:if>
</div>

<div id="footer">
	<h3>Sistema Informativo</h3>
</div>

</body>
</html>