package com.sabadell.MonitorAmbientesBatch.service;

import com.sabadell.MonitorAmbientesBatch.dto.MONTOperacionDTO;
import com.sabadell.MonitorAmbientesBatch.dto.NodosyServidoresDTO;

public interface MonitorAmbientesService {

	/**
	 * Valida el nodo y la URL haciendo un request y un ping respectivamente.
	 * 
	 * @param objeto objeto con los datos del nodo y los ambientes de Sofom y Bantotal
	 * @return los resultados de las validaciones.
	 */
	MONTOperacionDTO ValidarNodoyURL(NodosyServidoresDTO objeto);
}
