<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livraria Digital</title>
</head>
<body>
<h1>
Deseja realmente excluir esse livro?
</h1>

<table border="1">
			
			<tr bgcolor="6c7b8b" align="center">
				<td>ID</td>
				<td>${livro.id}</td>
			</tr>
			<tr>
				<td>Título</td>
				<td>${livro.titulo}</td>
			</tr>
			<tr>
				<td>Autor</td>
				<td>${livro.autor}</td>
			</tr>
			<tr>
				<td>Editora</td>
				<td>${livro.editora}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td><c:if test="${not empty livro.email}">
						<a href="mailto:${livro.email}">${livro.email}</a>
					</c:if>
				<c:if test="${empty livro.email}">
					E-mail não informado
				</c:if></td>
			</tr>
			
			<tr>
				<td>Data de Lançamento</td>
				<td>"${livro.dataLancamento}"</td>
			</tr>
		</table>
	<form action="ExcluirLivro" method="post">
		<br>
		<input type="hidden" name="codigo" id="codigo" value="${livro.id}">
		
		<input type="submit" value="Excluir">
	</form>
</body>
</html>