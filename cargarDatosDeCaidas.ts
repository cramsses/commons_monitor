	cargarDatosDeCaidas() {
		this.obtenerLaHoraActual();
		this._monitorAmbientesService.obtenerNumeroCaidas().subscribe(	
			result => {
				this.listaNumeroCaidas = JSON.parse(JSON.stringify(result));  

				var indiceInterno = 0;
				let bandera: boolean = false;
				let listaCaidas: Array<any>;
				let lista: Array<any> = new Array();
				let listaTitulos: Array<any> = new Array();

				listaTitulos.push("Hora");
				for (var i = 0; i < this.listaAmbientes.length; i+=1) {
					listaTitulos.push(this.listaAmbientes[i]["nombreAmbiente"]);
				}
				lista.push(listaTitulos);

				for (var j = 0; j <= this.horaActual; j+=1) {
					listaCaidas = new Array();
					listaCaidas.push(j.toString());//Hora

					for (var k = 0; k < this.listaAmbientes.length; k+=1) {
						listaCaidas.push(0);//Valor default a cero para la hora dada
						for(var l = 0; l < this.listaNumeroCaidas.length; l+=1) {
							if(this.listaAmbientes[k]["idAmbiente"]==this.listaNumeroCaidas[l]["idAmbiente"] && 
								parseInt(this.listaNumeroCaidas[l]["hora"])==j) {
								console.log(this.listaNumeroCaidas[l]["hora"]+'--->'+parseInt(this.listaNumeroCaidas[l]["hora"]));
								listaCaidas.pop();
								listaCaidas.push(this.listaNumeroCaidas[indiceInterno]["numCaidas"]);
							}
						}
					}
					lista.push(listaCaidas);
					console.log('listaCaidas'+listaCaidas);
				}

				this.datosTablaCaidas =  {
					chartType: 'LineChart',
					dataTable: lista,
					options: {
						height: 280,
			  		    chartArea:{left: 38,top: 10,width:'75%',height:'80%'},
			  		    hAxis: { gridlines: { count: 8 }, title:'Hora',format:'hh:mm' },
			  		    vAxis: { gridlines: { count: 2 },format:'0' }	
				  	}
				};
			},
            error => {
            	console.log("Llega directamente al error");
                console.log(<any>error);
            }
		);
	}