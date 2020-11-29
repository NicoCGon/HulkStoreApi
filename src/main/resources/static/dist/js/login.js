$(function () {	
	if($("#error").html() != undefined){
		construirMensajeLogin( $("#error").val(), "danger");
	}
	else if($("#logout").html() != undefined){
		construirMensajeLogin( $("#logout").val(), "info");
	}
});