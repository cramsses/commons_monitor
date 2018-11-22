import {DisponibilidadDetalle} from  '../model/disponibilidadDetalle.model';


export class ListasDisponibilidadDetalle {
	constructor (
		public listaNodos: Array<DisponibilidadDetalle>,
		public listaAmbientes: Array<DisponibilidadDetalle>,
		public listaBaseDatos: Array<DisponibilidadDetalle>,
		public listaAplicaciones: Array<DisponibilidadDetalle>
	){}
}