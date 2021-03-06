<%@ page language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.models.*" %>
<%@ page import="com.view.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<c:if test="${not empty param.language}">
  <c:set var="language" value="${param.language}" scope="session"/>
</c:if>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="bundles.Bundle" />
<html>
<head>
<title><fmt:message key="categorie.titre.page"/></title>
</head>
<body bgcolor="#FFFFFF">
<h1><fmt:message key="categorie.titre.liste"/></h1>
<form method='post' action='adminCategorie'>
 <table border='1' align='center'>
   <tr>
    <td>Chercher une catégorie:<input type='text' name='motCle'
	value='${(empty catForm)?catForm.motCle:""}'></td>
    <td><input type='submit' name='chercheCat' value='Chercher'></td>
   </tr>
 </table>
</form>
<form method='post' action='adminCategorie'>
  <table border='1' align='center'>
    <tr>
      <td>Id Catégorie<td>Nom Catégorie</td><td>Description</td>
    </tr>
    <tr>
     <td></td>
     <td><input type='text' name='nomCat'></td>
     <td><input type='text' name='description' size='40'></td>
     <td><input type='submit' name='addCat' value='Ajouter'></td>
    </tr>
     <c:if test="${not empty catForm}">
      
     <c:forEach items="${catForm.lesCats}" var="cat">
 		<tr>
		      <td>${cat.id}</td>
		      <td>${cat.nom}</td>
		      <td>${cat.description}</td>
		      <c:url value="adminCategorie" var="myURL">
				  <c:param name="idCat" value="${cat.id}"/>
				</c:url>
 

		      <td><a href='<c:out value="${myURL}"/>'>Supprimer</a></td>
		 </tr>
	</c:forEach>
	</c:if>
  </table>
</form>

</body>
</html>
