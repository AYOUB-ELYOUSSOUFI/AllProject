<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire</title>
</head>
<body bgcolor="blue">
<h2>Enregistrements de vos coordonnees</h2>
<form method="get" action="formulaire">
	<h3>Civilite
	<select name="civilite">
		<option>Monsieur</option>
		<option>Madame</option>
		<option>Mademoiselle</option>
	</select>
	</h3>
	<h3>Nom : <input type="text" name="nom" size="24" style="margin-left: 30px;"/></h3>
	<h3>Prenom : <input type="text" name="prenom" size="24" /></h3>
	<h3>Age : <input type="text" name="age" size="5" /></h3>
	<hr>
	<input type="submit" value="Envoyer le formulaire" />
	<input type="reset" value="Tout effacer"/>
</form>
</body>
</html>