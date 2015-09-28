<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.uniroma3.model.*"
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
	Prodotto prodottoOrdine = (Prodotto) session.getAttribute("prodottoOrdine");
	
	

%>
  
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/FileCss.css">
<title>Dettaglio Prodotto</title>
</head>
<body>
<div id="header">
	<h1>Dettaglio Prodotto Da Ordinare</h1>
</div>


<div id="content">

<table width="100%">
<tr>
<td width="60%">
<p>NOME PRODOTTO:</p>
<p>${prodottoOrdine.nome}</p>
<p>DESCRIZIONE PRODOTTO:</p>
<p>${prodottoOrdine.descrizione}</p>
<p>CODICE:</p>
<p>${prodottoOrdine.codice}</p>
<p>COSTO UNITARIO:</p>
<p>${prodottoOrdine.costo} €</p>
<p>DISPONIBILITA:</p>
<p>${prodottoOrdine.disponibilita} Pezzi</p>
</td>
<td>
<p>Aggiungi la quantita di prodotto da acquistare</p>
<form method="post" action="aggiungiProdottoOrdine.do">
<p>Quantita:<input type="text" name="quantita"/></p>
<p>${mappaProdottoAggiunto["quantita"] }</p>
<p><input type="submit" name="aggiungi" value="Aggiungi Al Carrello"/></p>
</form>
<td>
</tr>
</table>
<a href="effettuaOrdine.jsp"><button>Vai Alla Pagina Precedente</button></a>



</div>
<div id="footer">
	<h3>Sistema Informativo</h3>
</div>

</body>
</html>