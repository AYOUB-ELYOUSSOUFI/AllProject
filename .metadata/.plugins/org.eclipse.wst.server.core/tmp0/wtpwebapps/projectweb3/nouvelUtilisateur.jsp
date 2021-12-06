<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>-->
<%@ page errorPage="/WEB-INF/erreur.jsp" %>
	<%@ include file="/WEB-INF/jspf/header.jspf" %>
	
	<h3 aligne="center">Demande d'inscription</h3>
	<form action="validerUtilisateur.jsp" method="post">
		<p>
		<table border="1" cellpadding="3" cellspacing="2" width="90%" align="center">
			<tr>
				<td bgcolor="#FF9900" width="100"><b>Nom</b></td>
				<td><input type="text" name="nom" /></td>
			</tr>
			<tr>
				<td bgcolor="#FF9900" width="100"><b>Prenom</b></td>
				<td><input type="text" name="prenom"/></td>
			</tr>
			<tr>
				<td bgcolor="#FF9900" width="100"><b>Mot de pass</b></td>
				<td><input type="password" name="motDePass"/></td>
			</tr>
		</table>
		</p>
		<p align="center"><input type="submit" value="Nouvel Utilisateur"/></p>
	</form>	
	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
