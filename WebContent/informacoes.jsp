<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp" />
	<div id="main" class="container">
		<h2 class="page-header">Informações</h2>
		<p class="lead">
			<del>Teste</del>
		</p>
		<p>
			<del>Teste</del>
		</p>
		<p>
			<ins>Teste</ins>
		</p>
		<p>
			<small>Teste</small>
		</p>
		<p>
			<strong>Teste</strong>
		</p>
		<p>
			<em>Teste</em>
		</p>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>