<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h1 align="center">La liste des contacts</h1>
	<s:if test="%{listContact.size()>0}">
		<table border="1" align="center">
			<tr>
				<th>Identifiant</th>
				<th>Nom</th>
				<th>Email</th>
				<th>Code Postal</th>
				<th>Date d'inscription</th>
				<th>Photo</th>
				<th>Action</th>
			</tr>
			<s:iterator value="listContact">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="nom" /></td>
					<td><s:property value="mail" /></td>
					<td><s:property value="codePostal" /></td>
					<td><s:property value="dateInscription" /></td>
					<td><img src="photos/${photo}"/></td>
					<td>
						<s:url action="supprimerContact" var="sup">
							<s:param name="idDelete" value="id"></s:param>
						</s:url>
						<s:a href="%{sup}">supprimer</s:a>
					 </td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
	<a href="saisirContact.action">Ajouter un Contact</a><br/>
</body>
</html>