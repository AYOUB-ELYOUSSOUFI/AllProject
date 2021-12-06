<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enregistrement des coordonnes</title>
</head>
<body bgcolor="orange" text="green">
	<h2>Enregistrements des coordonnes effictue</h2>
	<hr width="75%">
	<p><b> Bonjour
		   <%=request.getParameter("civilite")%> 
		   <%=request.getParameter("nom")%>
		   <%=request.getParameter("prenom")%> 
		   <%
			 int age = Integer.parseInt(request.getParameter("age"));
			 String message = "Vous etes un ";
			 if (age > 0 && age < 12)
			 	message += "enfant.";
			 if (age >= 12 && age < 18)
			 	message += "adolescent.";
			 if (age >= 18 && age < 60)
			 	message += "adulte.";
			 if (age >= 60)
			 	message += "une personne du troisieme age.";
		   %>
		   <p><%= message %></b>
</body>
</html>