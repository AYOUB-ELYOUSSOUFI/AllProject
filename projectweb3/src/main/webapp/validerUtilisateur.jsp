<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@ page errorPage="/WEB-INF/erreur.jsp" import="com.db.*" %>
	<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<h3 align="center"> Confirmation de votre demande d'inscription</h3>
	<jsp:useBean id="utilisateur" class="com.message.Personne">
	<jsp:setProperty name="utilisateur" property="*"/>
	<p>
		<table border="1" cellpadding="3" cellspacing="2" width="90%" align="center">
			<tr>
				<td bgcolor="#FF9900" width="100"><b>Nom</b></td>
				<td><jsp:getProperty name="utilisateur" property="nom"/></td>
			</tr>
			<tr>
				<td bgcolor="#FF9900" width="100"><b>Prenom</b></td>
				<td><jsp:getProperty name="utilisateur" property="prenom"/></td>
			</tr>
			<tr>
				<td bgcolor="#FF9900" width="100"><b>Mot de pass</b></td>
				<td><jsp:getProperty name="utilisateur" property="motDePass"/></td>
			</tr>
		</table>
	</p>
	<h3 align="center">
	<%if(!utilisateur.enregister()){%>
		<font color="red">Attention : Utilisateur déjà existé</font>
	<%
	}
	else{
	%>
		<font color="green">Nouvel utilisateur enregisteé</font>
	<%
	}
	utilisateur.arret();
	%>
	</h3>
	</jsp:useBean>
	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
