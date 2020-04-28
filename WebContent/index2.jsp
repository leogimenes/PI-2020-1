<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Cadastro de Pegada de Carbono</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<c:import url="Menu.jsp" />

	<div id="main" class="container">
		<h3 class="page-header">Cadastro de Pegada de Carbono</h3>

		<form action="ManterPegada.do" method="post">
			<div class="row">
				<div class="form-group col-md-4">
					<label for="NomeIndividual">Nome</label> <input type="text"
						class="form-control" name="NomeIndividual" id="NomeIndividual"
						required maxlength="100" placeholder="Nome completo">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-3">
					<label for="CPF_Individial">CPF</label> <input type="text"
						class="form-control" name="CPF_Individual" id="CPF_Individual"
						required maxlength="14" pattern="[0-9]{3,}+.[0-9]{3,}+.[0-9]{3,}+-[0-9]{2,}"placeholder="123.456.789-xx">
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-3">
					<label for="CEP">CEP</label> <input type="text"
						class="form-control" name="CEP" id="CEP" required maxlength="9"
						placeholder="CEP">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="Bairro">Bairro</label> <input type="text"
						class="form-control" name="Bairro" id="Bairro" required
						maxlength="100" placeholder="Nome do bairro">
				</div>
			</div>

			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="Incluir">Salvar</button>
					<a href="index2.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>