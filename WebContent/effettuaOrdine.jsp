<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.uniroma3.model.*"
    import="java.util.*"
    import="service.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%	
	Ordine ordine =(Ordine) session.getAttribute("ordine");
	Cliente cliente = (Cliente) session.getAttribute("cliente");
	if(ordine==null && cliente !=null){
		ordine = new Ordine();
		FacadeOrdine facade = new FacadeOrdineImpl();
		ordine.setStato("aperto");
		ordine.setData(new java.util.Date());
		ordine.setCliente(cliente);
		session.setAttribute("ordine", ordine);
	}
	FacadeProdotto facade = new FacadeProdottoImpl();
	List<Prodotto> listaProdotti = facade.restituisciProdotti();
	session.setAttribute("listaProdotti", listaProdotti);
	
	
	boolean convalida;
	if(cliente !=null)
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
<title>Effettua Ordine</title>
</head>
<body>

<div id="header">
	<h1>Prodotti Da Ordinare</h1>
</div>




<div id="content">
<c:if test="${prodottoIns==true}">
<form method="post" action="completaOrdine.do">
<p>Per completare l'ordinazione clicca qui
<input type="submit" name="ordinecompleto" value="Completa Ordine"/>
</p>
</form>
</c:if>
<table width="100%">
<c:forEach var="iter" items="${listaProdotti}"> 
<tr> 
<td width="60%">
<p><strong>${iter.nome}</strong></p>
<p>CODICE:${iter.codice}</p>
<p>COSTO:${iter.costo}€</p>
</td>
<td>
<form method="get" action="dettaglioProdottoOrdine.do">
	<input type="hidden" name="nome" value="${iter.nome}"/>
	<input type="hidden" name="descrizione" value="${iter.descrizione}"/>
	<input type="hidden" name="prezzo" value="${iter.costo}"/>
	<input type="hidden" name="codice" value="${iter.codice}"/>
	<input type="hidden" name="disponibilita" value="${iter.disponibilita}"/>
	<p><input type="submit" name="dettaglio" value="DettaglioProdotto"/></p>
</form>
</td>

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