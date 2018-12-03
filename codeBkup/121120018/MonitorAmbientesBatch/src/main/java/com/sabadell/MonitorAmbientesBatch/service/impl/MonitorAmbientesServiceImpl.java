package com.sabadell.MonitorAmbientesBatch.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.sabadell.MonitorAmbientesBatch.dto.MONTOperacionDTO;
import com.sabadell.MonitorAmbientesBatch.dto.NodosyServidoresDTO;
import com.sabadell.MonitorAmbientesBatch.service.MonitorAmbientesService;
import com.sabadell.MonitorAmbientesBatch.utils.Utils;

@Service
public class MonitorAmbientesServiceImpl implements MonitorAmbientesService {

	public MonitorAmbientesServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static final long MIL = 1000;

	/**
	 * Valida el nodo y la URL haciendo un request y un ping respectivamente.
	 * 
	 * @param objeto objeto con los datos del nodo y los ambientes de Sofom y Bantotal
	 * @return los resultados de las validaciones.
	 */
	@Override
	public MONTOperacionDTO ValidarNodoyURL(NodosyServidoresDTO objeto) {
		MONTOperacionDTO objetoOperacion = new MONTOperacionDTO();
		objetoOperacion.setFecha(new Date(System.currentTimeMillis()));
		Double tiempoInicial = (double)System.currentTimeMillis();
		objetoOperacion.setIdEstatus(Utils.validarEstatusURL(objeto.getDireccion()));
		//objetoOperacion.setIdServidor(objeto.getIdServidor());
		objetoOperacion.setTiempoRespuesta((tiempoInicial-(double)System.currentTimeMillis())/MIL);		//validaciones:
		return objetoOperacion;	
	}
}
