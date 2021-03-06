<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<sx:head />
<meta http-equiv="Content-Type" charset="ISO-8859-1">
<title><s:text name="annuaire.form.newContact.title" /></title>
</head>
<body>
	<center>
		<s:url var="saisirContactEN" action="saisirContact">
			<s:param name="request_local">en</s:param>
		</s:url>
		<s:url var="saisirContactES" action="saisirContact">
			<s:param name="request_local">es</s:param>
		</s:url>
		<s:url var="saisirContactFR" action="saisirContact">
			<s:param name="request_local">fr</s:param>
		</s:url>
	</center>
	<s:a href="%{saisirContactEN}">English</s:a>
	<s:a href="%{saisirContactES}">Spanish</s:a>
	<s:a href="%{saisirContactFR}">Fran?ais</s:a>
	<h2>L'ajout d'un Contact</h2>
	<div>
		<s:actionerror />
	</div>
	<div id="formulaire">
		<s:form method="post" action="enregistrerContact"
			enctype="multipart/form-data" validate="true">
			<s:textfield name="nom" id="nom" label="Nom  " />
			<s:textfield name="mail" id="mail" label="Email  " />
			<s:textfield name="codePostal" id="codePostal" label="code Postal  " />
			<sx:datetimepicker name="dateInscription" displayFormat="yyyy-MM-dd" label="Date inscription" />
			<s:file name="photo" label="Fichier" />
			<s:submit value="Add" />
		</s:form>
	</div>
</body>
</html>