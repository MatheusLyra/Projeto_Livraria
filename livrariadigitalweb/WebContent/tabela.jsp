<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	</head>
	<body>
		<!--<c:import url="cabecalho.jsp" />-->
		<!--<jsp:useBean id="dao" class="livrariadigital.dao.LivroDao"></jsp:useBean>-->
		<table border="1">
			<tr bgcolor="6c7b8b" align="center">
				<td>Id</td>
				<td>Titulo</td>
				<td>Autor</td>
				<td>Editora</td>
				<td>E-mail</td>
				<td>Data de lançamento</td>
				<td>Ações</td>
			</tr>

			<c:forEach var="livro" items="${livros}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'd3d3d3' : 'ffffff' }">
				<td>${livro.id}</td>
				<td>${livro.titulo}</td>
				<td>${livro.autor}</td>
				<td>${livro.editora}</td>
				<td>
					<c:if test="${not empty livro.email}">
						<a href="mailto:${livro.email}">${livro.email}</a>
					</c:if>
					<c:if test="${empty livro.email}">
						E-mail não informado
					</c:if>
				</td>
				<td>
					<fmt:formatDate value="${livro.dataLancamento.time}" pattern="dd/MM/yyyy"/>
				</td>
				<td>
					<span><a href="AlterarLivro?id=${livro.id}" class="btn btn-default btn-xs active">Alterar</span></a>
					 
					<span><a href="ExcluirLivro?id=${livro.id}" class="btn btn-danger btn-xs active">Excluir</span></a>
					
					<!-- <span><a href="DetalharLivr?id=${livro.id}" class="btn btn-success btn-xs active">Detalhar</span></a> -->
				</td>
			</tr>
			</c:forEach>
		</table>
		<!--<c:import url="rodape.jsp" />-->
	</body>
</html>