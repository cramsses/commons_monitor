import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class ServiciosAdicionalesService {
	constructor(
		public http: HttpClient
	) {
	}

	public obtenerHoraDelSistema(){
		//return this.http.get('http://banapp6a:15128/monitorAmbientesServ-0.1/ServiciosAdicionales/hora/H'); 
		return this.http.get('http://localhost:8443/ServiciosAdicionales/hora/H');  
	}

	public obtenerMinutosDelSistema(){
		//return this.http.get('http://banapp6a:15128/monitorAmbientesServ-0.1/ServiciosAdicionales/hora/m'); 
		return this.http.get('http://localhost:8443/ServiciosAdicionales/hora/m');  
	}
}