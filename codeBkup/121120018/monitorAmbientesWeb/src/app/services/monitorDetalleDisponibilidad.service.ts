import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class MonitorDetalleDisponibilidadService{

	constructor(public http: HttpClient) {

	}

	public obtenerDetalleDisponibilidad(){

		return this.http.get('http://localhost:8443/MonitorController/disponibilidadDetalle');

	}

}
