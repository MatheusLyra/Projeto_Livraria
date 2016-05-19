/**
 * Controles AJAX
 */

$(document).ready(function() {
	 $('#botao').click(function(){ //Quando clicado no elemento input
		 $( '#quadrado' ).show( 'blind', 1000 );
    	 // alert( $('#botao').val());
          $.ajax({
              url: 'tabela.jsp',
              success: function(data) {
                $('#quadrado').html(data);
                //alert(data);
              }
        });
          
      });
});