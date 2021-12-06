<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@ page isErrorPage="true" %>
	<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<centre>
		<h1><font color="red">Erreur ...</font></h1>
		<p>Votre demande n'a pu aboutir</p>
		<p>Merci de signaler les circonstances de cet incidents au webmaster 
		<br> de ce site en lui transmettant le texte d'arreur aui suit : </p>
		<p><b><%= exception %></b></p>
	</centre>
	
	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
	
