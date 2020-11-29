$(function () {	
	if($("#error").html() != undefined){
		construirMensajeLogin( $("#error").val(), "danger");
	}
	$(".btn-alta").on("click",function(){
    	var form = $("#formGeneral");
		$.post("verificarAltaSolicitud",form.serialize(),function(response){
			if(response.indexOf("OK") >= 0){
				if(!filtroAlta || !filtroObservacion){
					$("#wait").show();
					form.submit();
				}
		    	else{

					if(!filtroAlta) 
						$("#presentarCashCollateral").addClass("invisible");
					else
						$("#presentarCashCollateral").removeClass("invisible");
					
					$("#modal-cash-collateral").modal("show");
		    	}
			}
			else if(response.indexOf("ERROR") >= 0)
				mensajeErrorServidor();
			else
				construirMensaje(response,"warning","Alta Solicitud");

		}).fail(function(){
			mensajeErrorServidor("Error al verificar el alta del cliente");
    	});
	});

});
