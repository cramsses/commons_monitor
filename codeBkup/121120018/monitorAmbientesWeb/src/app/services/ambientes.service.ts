import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class AmbientesService {
	constructor(
		public http: HttpClient
	) {
	}

	public obtenerAmbientes(){
		//return this.http.get('http://banapp6a:15128/monitorAmbientesServ-0.1/catalogosController/ambientes');   
		return this.http.get('http://localhost:8443/catalogosController/ambientes');   
	
	}
}