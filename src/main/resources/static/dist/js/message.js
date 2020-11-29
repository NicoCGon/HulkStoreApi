function construirMensajeLogin(mensaje,tipo){
	var titulo = tipo == "danger" ? "Error!" : "Importante!"; 
	
	$(".alert").remove();
	$.notify({ title: "<strong>" + titulo +"</strong>", message: " Login <h5> " + mensaje +" </h5>" },{
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
		delay: 1000,
		timer: 1000,
		z_index: 2000
	});
}