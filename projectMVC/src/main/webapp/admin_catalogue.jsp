<%@page import="com.view.CategorieForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.models.*"  %>    
<%@ page import="com.view.CategorieForm"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des categories</title>
</head>
<body>
	<% CategorieForm cf = (CategorieForm)session.getAttribute("catForm"); %>
	<form action="catalogue" method="post">
		<table border="1" align="center">
			<tr>
				<td>Chercher une categorie:<input type="text" name="motCle" value='<%= (cf != null) ? cf.getMotCle() : "" %>'/></td>
				<td><input type="submit" name="chercheCat" value="Chercher"/></td>
			</tr>
		</table>
	</form>
	<form action="catalogue" method="post">
		<table border="1" align="center">
			<tr>
				<td>Id categorie</td>
				<td>Nom categorie</td>
				<td>Description</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" name="nomCat" /></td>
				<td><input type="text" name="description" size="40" /></td>
				<td><input type="submit" name="addCat" value="Ajouter" /></td>
			</tr>
			<% if(cf!=null){
				for(Categorie cat : cf.getLesCategories()){			
			%>
			<tr>
				<td><%= cat.getIdCat() %></td>
				<td><%= cat.getTitre()%></td>
				<td><%= cat.getDesignation()%></td>
				<td><a href="catalogue?idCat=<%=cat.getIdCat()%>">Supprimer</a></td>
			</tr>
			<%
				}
			}
			%>
		</table>
	</form>
</body>
</html>