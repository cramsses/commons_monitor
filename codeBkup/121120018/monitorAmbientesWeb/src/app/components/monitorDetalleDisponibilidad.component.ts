import {Component} from '@angular/core';
import { HostListener } from '@angular/core';

import {DisponibilidadDetalle} from  '../model/disponibilidadDetalle.model';
import {ListasDisponibilidadDetalle} from  '../model/listasDisponibilidadDetalle.model';
import {MonitorDetalleDisponibilidadService} from  '../services/monitorDetalleDisponibilidad.service';

@Component ({
	selector: 'monitorDetalleDisponibilidad',
	templateUrl:'../views/monitorDetalleDisponibilidad.html',
	styleUrls: ['../styles/monitorAmbientes.css'],
	providers: [MonitorDetalleDisponibilidadService]
})

export class MonitorDetalleDisponibilidadComponent{

	public titulo='Componente Detalle Disponibilidad';


	private listasDisponibilidadDetalle:ListasDisponibilidadDetalle;
	private listaDetalleDisponibilidadNodos:Array<DisponibilidadDetalle>;
	private listaDetalleDisponibilidadAmbientes:Array<DisponibilidadDetalle>;
	private listaDetalleDisponibilidadBaseDatos:Array<DisponibilidadDetalle>;
	private listaDetalleDisponibilidadApps:Array<DisponibilidadDetalle>;

	constructor(private _monitorDetalleDisponibilidadService: MonitorDetalleDisponibilidadService){

		
		this.listaDetalleDisponibilidadNodos = new Array<DisponibilidadDetalle>();
		this.listaDetalleDisponibilidadAmbientes = new Array<DisponibilidadDetalle>();
		this.listaDetalleDisponibilidadBaseDatos = new Array<DisponibilidadDetalle>();
		this.listaDetalleDisponibilidadApps = new Array<DisponibilidadDetalle>();
	}

	ngOnInit(){
		console.log("ngOnInit");
		this.cargarAnchoVentana();
		this.obtenerInformacion();
		
		
	}

	obtenerInformacion(){
		/*Llamar al servicio que trae las  4 listas*/
		//alert('Cargando');
		this._monitorDetalleDisponibilidadService.obtenerDetalleDisponibilidad().subscribe(
			result => {
				console.log("result: \n"+JSON.stringify(result));
				this.listasDisponibilidadDetalle = JSON.parse(JSON.stringify(result));
				
				this.listaDetalleDisponibilidadNodos = this.listasDisponibilidadDetalle.listaNodos;
				//console.log(this.listaDetalleDisponibilidadNodos);
				
				this.listaDetalleDisponibilidadAmbientes = this.listasDisponibilidadDetalle.listaAmbientes;
				//console.log(this.listaDetalleDisponibilidadAmbientes);
				
				this.listaDetalleDisponibilidadBaseDatos = this.listasDisponibilidadDetalle.listaBaseDatos;
				//console.log(this.listaDetalleDisponibilidadBaseDatos);

				this.listaDetalleDisponibilidadApps = this.listasDisponibilidadDetalle.listaAplicaciones;
				//console.log(this.listaDetalleDisponibilidadApps);
			},
			error => {
            	console.log("Error en cargarInformacion()");
                console.log(<any>error);
            }
		);
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
			//this.listaTitulos = new Array("Ambiente","Nodo1","Nodo2","Balanceador BANTOTAL","banapp1 BANTOTAL","Banapp2 BANTOTAL","Balanceador SOFOM","banapp1 SOFOM","banapp SOFOM");
		} else {
			contenedor1.classList.remove("contenedorSupIzqGrande");
			contenedor2.classList.remove("contenedorSupDerGrande");
			contenedor3.classList.remove("contenedorInfIzqGrande");
			contenedor4.classList.remove("contenedorInfDerGrande");

			contenedor1.classList.add("contenedorSupIzqChico");
			contenedor2.classList.add("contenedorSupDerChico");
			contenedor3.classList.add("contenedorInfIzqChico");
			contenedor4.classList.add("contenedorInfDerChico");
			//this.listaTitulos = new Array("AMB","N1","N2","BAL BAN","N1 BAN","N2 BAN","BAL SOF","N1 SOF","N2 SOF");
		}
	}

	@HostListener('window:resize', ['$event'])
	onResize(event) {
		this.cargarAnchoVentana();
	}


}