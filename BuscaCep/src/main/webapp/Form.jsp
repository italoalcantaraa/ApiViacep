<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="StyleForm.css">
</head>
<body>
	
	<%@ include file="../Cabecalho.html"%>
	<div class="formulario">
		<form action="ServletCep" method="post">
			<input type="number" required pattern="\d{5}-\d{3}" id="cep"
				name="cep" placeholder="Informe o cep"> <input type="submit"
				value="Consultar" id="consultar">
		</form>
	</div>
</body>
</html>