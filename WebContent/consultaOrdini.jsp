<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.uniroma3.model.*"
    import ="java.util.*"
    import="it.uniroma3.persistence.postgres.proxy.*"
    import="service.*"%>
    
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
	Cliente cliente = (Cliente) session.getAttribute("cliente");

	boolean convalida;
	if(cliente !=null)
	 		convalida = true;
	else convalida = false;
	if(!convalida){
	 		out.clear();
	 		RequestDispatcher rd = application.getRequestDispatcher("/login.jsp");
	 		rd.forward(request, response);
	}
	FacadeOrdine facade = new FacadeOrdineImpl();
	List<Ordine> listaOrdiniClienti = facade.ordiniCliente(cliente);
	request.setAttribute("listaOrdiniClienti", listaOrdiniClienti);
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/FileCss.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Ordini Del Cliente</title>
</head>
<body>
<div id="header">
	<h1>Lista Ordini Del Cliente</h1>
</div>

<div id="content">
<p>In questa pagina ${cliente.nome} ${cliente.cognome} puoi trovare lo storico dei tuoi ordini</p>
<table border="1" cellspacing="2">
<tr>
	<th>ID ORDINE</th>
	<th>DATA DI ORDINAZIONE</th>
	<th>STATO DELL'ORDINE</th>
</tr>

<c:forEach var="ordine" items="${listaOrdiniClienti}">

<tr>
	
	<td>${ordine.id}</td>
	<td>${ordine.data}</td>
	<td>${ordine.stato}</td>

</tr>
	
</c:forEach>

</table>
<a href="accesso.jsp"><button>Vai Alla Pagina Di Amministrazione</button></a>
</div>


<div id="footer">
	<h3>Sistema Informativo</h3>
</div>

</body>
</html>