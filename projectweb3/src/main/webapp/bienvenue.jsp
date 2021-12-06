<%@page import="com.message.ListeMessages"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%@ page errorPage="/WEB-INF/erreur.jsp" import="com.message.*"%>
	 <%@ include file="/WEB-INF/jspf/header.jspf"%>
	<font face="Arial">
		<p>
		<table border="1" cellpadding="3" cellspacing="2" width="90%" align="center">
			<tr bgcolor="#FF6600">
				<th>Sujet</th>
				<th>Messages</th>
			</tr>
			<%
			ListeMessages listeMessages = new ListeMessages(1);
			int ligne = 0;
			while (listeMessages.suivant()){				
			%>
			<tr bgcolor="<%= ligne++%2 ==0 ? "#FFFF66" : "#FFCC00" %>">
				<td><b><%= listeMessages.sujet() %></b></td>
				<td><%= listeMessages.texte() %></td>
			</tr>
			<%
				}
			listeMessages.arret();
			%>
		</table>
		</p>
	</font>
	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
 