/**
 * Controles AJAX
 */

$(document).ready(function() {
	 $('#botao').click(function(){ //Quando clicado no elemento input
		 $( '#quadrado' ).show( 'blind', 1000 );
//		 alert( "teste");
    	 
          $.ajax({
        	  type: "POST",
              url: 'ListarLivros',
              data: "busca=" + $("#busca").val() + "&tipoBusca=" + $("#tipoBusca").val(),
              success: function(data) {
                $('#quadrado').html(data);
                //alert(data);
              }
        });
          
      });
	 
	 
	 
});



//    $.ajax({
//        type: "POST",
//        url:"ListarLivros",
//        data: "titulo=" + $("#titulo").val(),
//        success: function(response) {
////            alert(MODELO_FORMULARIO_SALVO);
////            modelos();
////            modeloListar();
////            modeloOperacaoReset();
//        }
////    ,
////        error: function(response) {
////            alert(GLOBAL_ERROR);
////        }
//    });
