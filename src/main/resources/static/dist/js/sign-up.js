$(function () {	
	if($("#error").html() != undefined){
		if($("#error").val().toString().indexOf("201") >= 0){
			construirMensajeLogin( "Felicitaciones, ya es miembro de la tienda!", "success");
		}
		else{
			construirMensajeLogin( "No se puede crear el usuario dado que ya existe, presione Sign Up para ir al login", "danger");
		}
	}
});
