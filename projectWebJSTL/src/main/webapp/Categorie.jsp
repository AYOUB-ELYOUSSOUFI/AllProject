<%@ page language="java"%>
<%@ page import="java.util.*"%>
<%@ page import="com.models.*"%>
<%@ page import="com.view.CategorieForm"%>
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
	<form method='post' action='adminCategorie'>
		<table border='1' align='center'>
			<tr>
				<td>Chercher une catégorie:<input type='text' name='motCle'
					value='${(not empty catForm)?catForm.motCle:""}'></td>
				<td><input type='submit' name='chercheCat' value='Chercher'></td>
			</tr>
		</table>
	</form>
	<form method='post' action='adminCategorie'>
		<table border='1' align='center'>
			<tr>
				<td>Id Catégorie</td>
				<td>Nom Catégorie</td>
				<td>Description</td>
			</tr>
			<tr>
				<td></td>
				<td><input type='text' name='nomCat'></td>
				<td><input type='text' name='description' size='40'></td>
				<td><input type='submit' name='addCat' value='Ajouter'></td>
			</tr>
			<c:if test="${not empty catForm}">
				<c:forEach items="${catForm.lesCategories}" var="cat">
					<tr>
						<td>${cat.id}</td>
						<td>${cat.nom}</td>
						<td>${cat.description}</td>
						<c:url value="adminCategorie" var="myURL">
							<c:param name="idCat" value="${cat.id}" />
						</c:url>
						<td><a href='<c:out value="${myURL}"/>'>Supprimer</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
</body>
</html>