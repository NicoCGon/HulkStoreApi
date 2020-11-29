function construirMensajeLogin(mensaje,tipo){
	var titulo = tipo == "danger" ? "Error!" : "Importante!"; 
	
	$(".alert").remove();
	$.notify({ title: " <h5> <strong>" + titulo +"</strong> </h5> ", message: " <h5> " + mensaje +" </h5>" },{
		placement: {
			from: "bottom",
			align: "right"
		},
		offset: {
			x: 50,
			y: 50
		},
		newest_on_top: true,
		type: tipo,
		spacing: 10,
		delay: 3000,
		timer: 1000,
		z_index: 2000
	});
}

function mensajeErrorServidor(error){
	var danger = "Mensaje Servidor: <h5>" + (error === undefined ? "No se pudo ejecutar esta accion" : error) + ", intente nuevamente o contacte con el administrador del sistema!</h5>";
	construirMensajeLogin(danger,"danger");
}
