export class TiemposRespuesta {
	constructor (
		public idAmbiente : number,
		public ambiente: string,
		public hora: string,
		public tiempoRespAvg: number
	){}
}