<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.uniroma3.model.*"
    import="java.util.*"
    import="service.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	FacadeProdotto facade = new FacadeProdottoImpl();
	List<Prodotto> lista = facade.restituisciProdotti();
	session.setAttribute("lista", lista);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/FileCss.css">
<title>Pagina Principale</title>
</head>
<body>



<div id="header">
	<h1>Pagina Principale</h1>
</div>

<p>Se vuoi ordinare qualcosa e sei un utente registrato <a href="login.jsp">Vai Alla Pagina Di Login</a></p>


<div id="content">
<table width="100%">
<c:forEach var="iter" items="${lista}"> 
<tr> 
<td width="80%">
<p>${iter.nome}</p>
</td>
<td>
<form method="get" action="dettaglioProdotto.do">
	<input type="hidden" name="nome" value="${iter.nome}"/>
	<input type="hidden" name="descrizione" value="${iter.descrizione}"/>
	<input type="hidden" name="prezzo" value="${iter.costo}"/>
	<input type="hidden" name="codice" value="${iter.codice}"/>
	<input type="hidden" name="disponibilita" value="${iter.disponibilita}"/>

	
	<input type="submit" name="dettaglio" value="dettaglio"/>

</form>
</td>


</tr>


</c:forEach>
</table>

</div>

<div id="footer">
	<h3>Sistema Informativo</h3>
</div>



</body>
</html>