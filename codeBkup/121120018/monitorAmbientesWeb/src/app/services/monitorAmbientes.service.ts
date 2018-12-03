import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class MonitorAmbientesService {
	constructor(
		public http: HttpClient
	) {
	}

	public obtenerDatos(){
		//return this.http.get('http://banapp6a:15128/monitorAmbientesServ-0.1/MonitorController/ambientes');
		return this.http.get('http://localhost:8443/MonitorController/ambientes');   
	}

	public obtenerDisponibilidad(){
	  	//return this.http.get('http://banapp6a:15128/monitorAmbientesServ-0.1/MonitorController/disponibilidad'); 
	  	return this.http.get('http://localhost:8443/MonitorController/disponibilidad');   
	}

	public obtenerTiemposDeRespuesta(){
	  	//return this.http.get('http://banapp6a:15128/monitorAmbientesServ-0.1/MonitorController/tiempos');
	  	return this.http.get('http://localhost:8443/MonitorController/tiempos');   
	}

	public obtenerNumeroCaidas(){
	  	//return this.http.get('http://banapp6a:15128/monitorAmbientesServ-0.1/MonitorController/caidas');   
	  	return this.http.get('http://localhost:8443/MonitorController/caidas');   
	}
}