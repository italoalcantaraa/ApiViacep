<%@page import="viacep.ServicoDeCep"%>
<%@ page import="dominio.Endereco" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Endereco endereco = (Endereco)session.getAttribute("cep");
	
		out.print(endereco.getLogradouro());
		out.print(endereco.getBairro());
		out.print(endereco.getLocalidade());
	%>
</body>
</html>