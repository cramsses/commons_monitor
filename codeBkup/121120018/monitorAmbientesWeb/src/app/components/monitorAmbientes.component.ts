import {Component} from '@angular/core';
import * as $ from 'jquery';
import { HostListener } from '@angular/core';
import { DatosPorAmbiente } from '../model/datosPorAmbiente.model';
import { TiemposRespuesta } from '../model/tiemposRespuesta.model';
import { CaidasPorAmbiente } from '../model/caidasPorAmbiente.model';
import { DisponibilidadAmbientes } from '../model/disponibilidadAmbientes.model';
import { MonitorAmbientesService } from '../services/monitorAmbientes.service';
import { AmbientesService } from '../services/ambientes.service';
import { ServiciosAdicionalesService } from '../services/serviciosAdicionales.service';


@Component ({
	selector: 'monitorAmbientes',
	templateUrl:'../views/monitorAmbientes.html',
	styleUrls: ['../styles/monitorAmbientes.css'],
	providers: [MonitorAmbientesService, AmbientesService, ServiciosAdicionalesService]
})

export class MonitorAmbientesComponent {

	private horaActual: number;
	private minutoActual: number;
	public datosTablaCaidas:  any;
	public datosTablaTiempos:  any; 
	public datosDisponibilidad: Array<any>; 
	public listaDatosDisponibilidad: Array<DisponibilidadAmbientes>; 
	private listaTiemposRespuesta: Array<TiemposRespuesta>; 
	private listaNumeroCaidas: Array<CaidasPorAmbiente>; 
	private listaAmbientes: Array<CaidasPorAmbiente>; 
	public listaDatos : Array<DatosPorAmbiente>;
	public listaTitulos: Array<string>;
	private horaActualizacion:Date;
	private horaUltimaAct:string; 
	private fechaDia:string; 
	
	constructor (
		private _monitorAmbientesService: MonitorAmbientesService,
		private _ambientesService: AmbientesService,
		private _serviciosAdicionalesService: ServiciosAdicionalesService
	) {
		this.datosDisponibilidad = new Array();
		this.listaTitulos = new Array<string>();
		this.listaDatos = new Array<DatosPorAmbiente>();
		this.listaNumeroCaidas = new Array<CaidasPorAmbiente>();
		this.listaTiemposRespuesta = new Array<TiemposRespuesta>();
		this.listaDatosDisponibilidad = new Array<DisponibilidadAmbientes>();
		this.listaAmbientes = new Array<CaidasPorAmbiente>();
		this.horaActualizacion = new Date();
		this.horaUltimaAct ='';
		this.fechaDia = '';
	}

	ngOnInit (){
		this.cargarAnchoVentana();
		this.obtenerInformacion();
		setInterval(() => {this.cargarDatosTiemposDeRespuesta();this.actualizaHora();}, 60000);
		setInterval(() => {this.cargarDatosDeCaidas();this.actualizaHora();}, 15000);
		setInterval(() => {this.cargarDatosDeDisponibilidad();this.actualizaHora();}, 60000);
		setInterval(() => {this.cargarDatosDeAmbientes();this.actualizaHora();	}, 30000);
		this.cargarFechaDia();
		this.actualizaHora();
	}

	actualizaHora(){
		this.horaActualizacion = new Date()
		this.horaUltimaAct=this.horaActualizacion.getHours()+':'+
		(this.horaActualizacion.getMinutes()<10?'0'+this.horaActualizacion.getMinutes():this.horaActualizacion.getMinutes())+':'+
		(this.horaActualizacion.getSeconds()<10?'0'+this.horaActualizacion.getSeconds():this.horaActualizacion.getSeconds());
	}

	cargarFechaDia(){
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1;
		var yyyy = today.getFullYear();

		var dds =''+dd;
		if(dd<10) {
			dds = '0'+dd; 
		} 

		var mms = ''+mm;
		if(mm<10) {
		    mms = '0'+mm;
		} 

		this.fechaDia = dds + '/' + mms + '/' + yyyy;
	}

	cargarAnchoVentana(){
		let contenedor1:any = document.getElementById("contenedor1");
		let contenedor2:any = document.getElementById("contenedor2");
		let contenedor3:any = document.getElementById("contenedor3");
		let contenedor4:any = document.getElementById("contenedor4");

		let anchoVentana: number = window.innerWidth;
		//Extra largo
		if (anchoVentana > 1200) {

			contenedor1.classList.remove("contenedorSupIzqChico");
			contenedor2.classList.remove("contenedorSupDerChico");
			contenedor3.classList.remove("contenedorInfIzqChico");
			contenedor4.classList.remove("contenedorInfDerChico");

			contenedor1.classList.add("contenedorSupIzqGrande");
			contenedor2.classList.add("contenedorSupDerGrande");
			contenedor3.classList.add("contenedorInfIzqGrande");
			contenedor4.classList.add("contenedorInfDerGrande");
			this.listaTitulos = new Array("Ambiente","banapp1","banapp2","Balanceador IBM","banapp1 IBM","banapp2 IBM","Balanceador SOFOM","banapp1 SOFOM","banapp2 SOFOM");
		} else {
			contenedor1.classList.remove("contenedorSupIzqGrande");
			contenedor2.classList.remove("contenedorSupDerGrande");
			contenedor3.classList.remove("contenedorInfIzqGrande");
			contenedor4.classList.remove("contenedorInfDerGrande");

			contenedor1.classList.add("contenedorSupIzqChico");
			contenedor2.classList.add("contenedorSupDerChico");
			contenedor3.classList.add("contenedorInfIzqChico");
			contenedor4.classList.add("contenedorInfDerChico");
			this.listaTitulos = new Array("AMB","BAP1","BAP2","BAL IBM","BAP1 IBM","BAP2 IBM","BAL SFM","BAP1 SFM","BAP2 SFM");
		}
	}

	@HostListener('window:resize', ['$event'])
	onResize(event) {
		this.cargarAnchoVentana();
	}


	obtenerInformacion() {
		this.cargarListaDeAmbientes();
		this.cargarDatosTiemposDeRespuesta();
		this.cargarDatosDeCaidas();
		this.cargarDatosDeDisponibilidad();
		this.cargarDatosDeAmbientes();
	}

	obtenerLaHoraActual() {
		this._serviciosAdicionalesService.obtenerHoraDelSistema().subscribe(
			result => {
				this.horaActual = parseInt(JSON.parse(JSON.stringify(result)));  
			},
            error => {
            	console.log("Llega directamente al error");
                console.log(<any>error);
            }
		)
	}

	obtenerMinutoActual() {
		this._serviciosAdicionalesService.obtenerMinutosDelSistema().subscribe(
			result => {
				this.minutoActual = parseInt(JSON.parse(JSON.stringify(result)));  
			},
            error => {
            	console.log("Llega directamente al error");
                console.log(<any>error);
            }
		)
	}

	cargarListaDeAmbientes() {
		this._ambientesService.obtenerAmbientes().subscribe(
			result => {
				this.listaAmbientes = JSON.parse(JSON.stringify(result));  
			},
            error => {
            	console.log("Llega directamente al error");
                console.log(<any>error);
            }
		);
	}

	cargarDatosDeAmbientes() {
		this._monitorAmbientesService.obtenerDatos().subscribe(
			result => {
				this.listaDatos = JSON.parse(JSON.stringify(result));  
				$( document ).ready(function() {
		        	$("table td:contains(Caído)").css("background-color", "red").css("color", "white");

		        	$("table td:contains(N/A)").css("background-color", "gray").css("color", "white");

		        	$("tr:contains(FIX) td:not(:first-child)").css("background-color", "gray").css("color", "white").html('N/A');
		        	$("tr:contains(PRE) td:not(:first-child)").css("background-color", "gray").css("color", "white").html('N/A');
		        	$("tr:contains(PRO) td:not(:first-child)").css("background-color", "gray").css("color", "white").html('N/A');
		        	/*
		        	//$("tr:contains(GOS) td:nth-child(4) td:nth-child(6)").css("background-color", "gray").css("color", "white").html('N/A');
		        	$("tr:contains(GOS) td").filter(":nth-child(4), :nth-child(6), :nth-child(7), :nth-child(9)").css("background-color", "gray").css("color", "white").html('N/A');
		        	$("tr:contains(AC2) td").filter(":nth-child(7), :nth-child(8), :nth-child(9)").css("background-color", "gray").css("color", "white").html('N/A');
		    		*/
		    	});
			},
            error => {
            	console.log("Llega directamente al error");
                console.log(<any>error);
            }
		);
	}

	cargarDatosTiemposDeRespuesta() {
		this.obtenerLaHoraActual();
		this._monitorAmbientesService.obtenerTiemposDeRespuesta().subscribe(
			result => {
				this.listaTiemposRespuesta = JSON.parse(JSON.stringify(result));  
				let titulos;
				var indiceInterno = 0;
				let bandera: boolean = false;
				let listaTiempos: Array<any>;
				let lista: Array<any> = new Array();
				let listaTitulos: Array<any> = new Array();

				listaTitulos.push("Hora");
				for (var i = 0; i < this.listaAmbientes.length; i+=1) {
					listaTitulos.push(this.listaAmbientes[i]["nombreAmbiente"]);
				}
				lista.push(listaTitulos);
				
				for (var j = 0; j <= this.horaActual; j+=1) {
					listaTiempos = new Array();
					listaTiempos.push(j.toString());

					for (var k = 0; k < this.listaAmbientes.length; k+=1) {
						listaTiempos.push(0);
						for(var l = 0; l < this.listaTiemposRespuesta.length; l+=1) {
							if(this.listaAmbientes[k]["idAmbiente"]==this.listaTiemposRespuesta[l]["idAmbiente"] && 
								parseInt(this.listaTiemposRespuesta[l]["hora"])==j) {
								listaTiempos.pop();
								listaTiempos.push(this.listaTiemposRespuesta[indiceInterno]["tiempoRespAvg"]);
							}
						}
					}
					lista.push(listaTiempos);

				}
				alert('tiempos: '+lista);

				
				this.datosTablaTiempos =  {
					chartType: 'LineChart',
					dataTable: lista,
					options: {
						
						height: 280,	
			  		    chartArea:{left: 60,top: 10,bottom:50,right:130,width:'75%',height:'80%'},
			  		    hAxis: { gridlines: { count: 8 },
			  		    	title: 'Hora'
			  		    },
			  		    vAxis: { 
			  		    	title:'Tiempo(s)',
			  		    	gridlines: { count: 16 } ,
				  		    viewWindow: { min: 0 },
				  		    format:'0.000'
			  			}	
				  	}
				};
			},
            error => {
            	console.log("Llega directamente al error");
                console.log(<any>error);
            }
		);
	}

	cargarMinutosHora(hora:number){
		
		//var hora = 17;
		this.obtenerMinutoActual();
		var minutoActual = this.minutoActual;

		var listaMinHora: Array<any> = new Array();
		for(let idx=0;idx<minutoActual;idx++){
			let minute;
			minute=''+idx;
			if(idx<10){
				minute='0'+idx;
			}
			//console.log(hora+':'+minute);
			listaMinHora.push(hora+':'+minute)
		}
		//alert('hora'+listaMinHora);
		return listaMinHora;

	}

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
				lista.push(listaTitulos);//Se agregan las columasn-->addColumns



				for (var j = this.horaActual-2; j <= this.horaActual; j+=1) {

					var listaHoraCargada: Array<any>= this.cargarMinutosHora(j);
					//alert(listaHoraCargada);

					for(var m=0; m < listaHoraCargada.length;m++){
							//alert('A cargar: '+listaHoraCargada[m]);
							//TODO poner aqui la hora con minutos corresponunetes
							listaCaidas = new Array();
							//listaCaidas.push(j.toString());//Hora
							listaCaidas.push(listaHoraCargada[m].toString());//Hora

							for (var k = 0; k < this.listaAmbientes.length; k+=1) {
								listaCaidas.push(0);
								for(var l = 0; l < this.listaNumeroCaidas.length; l+=1) {
									if(this.listaAmbientes[k]["idAmbiente"]==this.listaNumeroCaidas[l]["idAmbiente"] && 
										this.listaNumeroCaidas[l]["hora"].valueOf()==listaHoraCargada[m].valueOf()	
										//parseInt(this.listaNumeroCaidas[l]["hora"])==listaHoraCargada[m]
										) {
										//console.log(this.listaNumeroCaidas[l]["hora"]+'--->'+parseInt(this.listaNumeroCaidas[l]["hora"]));
										listaCaidas.pop();
										listaCaidas.push(this.listaNumeroCaidas[indiceInterno]["numCaidas"]);
									}
								}
							}
							lista.push(listaCaidas);
							//console.log('listaCaidas'+listaCaidas);


					}


					
				}

				this.datosTablaCaidas =  {
					chartType: 'LineChart',
					dataTable: lista,
					options: {
						height: 280,
			  		    chartArea:{left: 38,top: 10,bottom:50,width:'75%',height:'80%'},
			  		    hAxis: { gridlines: { count: 2 }, title:'Hora',format:'heighth:mm' },
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

	cargarDatosDeDisponibilidad() {

		let x;
		let lista: Array<any> = new Array();
		this.datosDisponibilidad = new Array();
		this._monitorAmbientesService.obtenerDisponibilidad().subscribe(

			result => {
				this.listaDatosDisponibilidad = JSON.parse(JSON.stringify(result));  
				
				for (var i = 0; i < this.listaDatosDisponibilidad.length; i+=1) {
					var datoDisponibilidad =  {
					    chartType: 'Gauge',
						dataTable:  [
				            ['Label', 'Value'],
							[this.listaDatosDisponibilidad[i]["ambiente"],this.listaDatosDisponibilidad[i]["disponibilidad"]]
						],
					 	options: {
				        	width: 120, height: 120,
				        	redFrom: 1, redTo: 75,
				        	yellowFrom:75, yellowTo: 90,
				        	greenFrom:90, greenTo: 100,
				        	minorTicks: 5
					  	}
					};
					this.datosDisponibilidad.push(datoDisponibilidad);
				}
			},
            error => {
            	console.log("Llega directamente al error");
                console.log(<any>error);
            }
		);
	}
}