$(function () {	
	if($("#error").html() != undefined){
		construirMensajeLogin( $("#error").val(), "danger");
	}
});