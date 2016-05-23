<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro livros</title>
	
		
		<link href="css/jquery-ui.css" rel="stylesheet">
		<!-- <link href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" rel="stylesheet"> -->
		<script src="js/jquery-1.8.2.js"></script>
		<!-- < src="http://code.jquery.com/jquery-1.8.2.js"></> -->
		<script src="js/jquery-ui.js"></script>
		<!-- < src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></> -->
		

		
		<script>
			$(function() {
				$.datepicker.regional['pt-BR'] = {
		                closeText: 'Fechar',
		                prevText: '&#x3c;Anterior',
		                nextText: 'Pr&oacute;ximo&#x3e;',
		                currentText: 'Hoje',
		                monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho',
		                'Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		                monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun',
		                'Jul','Ago','Set','Out','Nov','Dez'],
		                dayNames: ['Domingo','Segunda-feira','Ter&ccedil;a-feira','Quarta-feira','Quinta-feira','Sexta-feira','Sabado'],
		                dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
		                dayNamesMin: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
		                weekHeader: 'Sm',
		                dateFormat: 'dd/mm/yy',
		                firstDay: 0,
		                isRTL: false,
		                showMonthAfterYear: false,
		                yearSuffix: ''};
		        $.datepicker.setDefaults($.datepicker.regional['pt-BR']);
				$("#data").datepicker();
			});

		</script>
	</head>
	<body>
		
		<form action="AdicionarLivro" method="post">
			<h2>Insira os dados do livro a ser cadastrado</h2><br>
			<table>
				<tr>
					<td>Título:</td>
					<td><input type="text" name="titulo" /></td>	
				</tr>
				<tr>
					<td>Autor:</td>
					<td><input type="text" name="autor" /></td>	
				</tr>
				<tr>
					<td>Editora:</td>
					<td><input type="text" name="editora" /></td>	
				</tr>
				<tr>
					<td>E-mail:</td>
					<td><input type="text" name="email" /></td>	
				</tr>
				<tr>
					<td>Data de Lançamento:</td>
					<td><input type="text" id="data" name="data"/></td>	
				</tr>
			</table>
	
			<input type="submit" value="cadastrar">
		</form>
		
	</body>
</html>
