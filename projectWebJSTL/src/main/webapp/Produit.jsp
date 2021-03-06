<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="com.models.*"%>
<%@ page import="com.view.ProduitForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${not empty param.language}">
	<c:set var="language" value="${param.language}" scope="session" />
</c:if>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.bundels.Bundle" />
<html>
<head>
<title><fmt:message key="categorie.titre.page" /></title>
</head>
<body bgcolor="#FFFFFF">
	<c:url value="" var="lngFr">
		<c:param name="language" value="fr" />
	</c:url>
	<c:url value="" var="lngEn">
		<c:param name="language" value="en" />
	</c:url>
	<c:url value="" var="lngEs">
		<c:param name="language" value="es" />
	</c:url>
	<p align="right">
		<a href='<c:out value="${lngFr}"/>'>FR</a> <a
			href='<c:out value="${lngEn}"/>'>EN</a> <a
			href='<c:out value="${lngEs}"/>'>ES</a>
	</p>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<h1>
		<fmt:message key="categorie.titre.liste" />
	</h1>
	<h2>
		<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
			value="${now}" />
	</h2>
	<form method='post' action='ProduitServlet'>
		<table border='1' align='center'>
			<tr>
				<td>Chercher un Produit par Categorie: <c:if
						test="${not empty prodForm}">
							<c:forEach items="${prodForm.lesCategories}" var="cat">
						<select name="motClePr">
								<option>${cat.nom}</option> 
						</select>
							</c:forEach>
					</c:if> 
				</td>
				<td><input type='submit' name='chercheProd' value='Chercher'></td>
			</tr>
		</table>
	</form>
	<form method='post' action='ProduitServlet'>
		<table border='1' align='center'>
			<tr>
				<td>Id Produit</td>
				<td>Description</td>
				<td>Prix</td>
				<td>Quantite</td>
				<td>Srd</td>
				<td>Categorie</td>
			</tr>
			<tr>
				<td></td>
				<td><input type='text' name='description' size='40'></td>
				<td><input type='text' name='prix'></td>
				<td><input type='text' name='quantite'></td>
				<td><input type='text' name='srd'></td>
				<td><select></select></td>
				<td><input type='submit' name='addProd' value='Ajouter'></td>
			</tr>
			<c:if test="${not empty prodForm}">
				<c:forEach items="${prodForm.lesProduits}" var="prod">
					<tr>
						<td>${prod.description}</td>
						<td>${prod.prix}</td>
						<td>${prod.qunatite}</td>
						<td>${prod.srd}</td>
						<td>${prod.lesCategories.nom}</td>
						<c:url value="adminCategorie" var="myURL">
							<c:param name="idCat" value="${prod.id}" />
						</c:url>
						<td><a href='<c:out value="${myURL}"/>'>Supprimer</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
</body>
</html>