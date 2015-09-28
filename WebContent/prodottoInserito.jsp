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
<title>Informazioni Prodotto</title>
</head>
<body>
<div id="header">
	<h1>Informazioni Prodotto Inserito</h1>
</div>
<div id="content">
<p>E' stato inserito il seguente prodotto</p>
<table>
<tr>
<th>NOME</th>
<th>COSTO</th>
<th>DESCRIZIONE</th>
<th>CODICE</th>
<th>PREZZO</th>
</tr>
<tr>
<td>
${prodottoInserito.nome }
</td>
<td>
${prodottoInserito.costo }
</td>
<td>
${prodottoInserito.descrizione }
</td>
<td>
${prodottoInserito.codice }
</td>
<td>
${prodottoInserito.disponibilita }
</td>
</tr>
</table>
<a href="accesso.jsp"><button>Vai Alla Pagina Di Amministrazione</button></a>
</div>
<div id="footer">
	<h3>Sistema Informativo</h3>
</div>
</body>

</html>