<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.uniroma3.model.*"
    %>
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
<title>Inserisci Prodotto</title>
</head>
<body>
<div id="header">
	<h1>Inserimento Prodotto</h1>
</div>
<div id="content">
<form method = "post" action= "inserimentoProdotto.do">
<p>nome: <input type=text name="nome" value = "${prodottoNonInserito.nome}"/>${mappaInsProd["nome"]}</p>
<p>costo: <input type=text name="costo" value = "${prodottoNonInserito.costo}"/>${mappaInsProd["costo"]}</p>
<p>descrizione: <input type=text name="descrizione" value = "${prodottoNonInserito.descrizione}"/>${mappaInsProd["descrizione"]}</p>
<p>codice: <input type=text name="codice" value = "${prodottoNonInserito.codice}"/>${mappaInsProd["codice"]}</p>
<p>disponibilita: <input type=text name="disponibilita" value = "${prodottoNonInserito.disponibilita}"/>${mappaInsProd["disponibilita"]}</p>

<p> <input type="submit" name="inserisci" value="Inserisci" />


</form>
<a href="accesso.jsp"><button>Vai Alla Pagina Di Amministrazione</button></a>
</div>
<div id="footer">
	<h3>Sistema Informativo</h3>
</div>
</body>
</html>