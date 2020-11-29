$(function () {	
	if($("#accept").html() != undefined){
		construirMensajeLogin( "Felicitaciones, ya es miembro de la tienda!", "success");
	}
	if($(".dangers").html() != undefined){
		var message = "";
		$(".dangers").each(function(){
			message += $(this).val() + " <br>";
		});
		construirMensajeLogin(message, "danger");
	}
});
