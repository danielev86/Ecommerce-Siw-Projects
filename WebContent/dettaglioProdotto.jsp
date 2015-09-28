<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.uniroma3.model.*"
    import="java.io.*"%>
    
    

  
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/FileCss.css">
<title>Dettaglio Prodotto</title>
</head>
<body>
<div id="header">
	<h1>Dettaglio Prodotto</h1>
</div>

<p>Se vuoi ordinare qualcosa e sei un utente registrato <a href="login.jsp">Vai Alla Pagina Di Login</a></p>

<div id="content">
<p>NOME PRODOTTO:</p>
<p>${prodotto.nome}</p>
<p>DESCRIZIONE PRODOTTO:</p>
<p>${prodotto.descrizione}</p>
<p>CODICE:</p>
<p>${prodotto.codice}</p>
<p>COSTO:</p>
<p>${prodotto.costo} €</p>
<p>DISPONIBILITA:</p>
<p>${prodotto.disponibilita} Pezzi</p>

<a href="home.jsp">Ritorna Alla Pagina Principale</a>
</div>
<div id="footer">
	<h3>Sistema Informativo</h3>
</div>

</body>
</html>