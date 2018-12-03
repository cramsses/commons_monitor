package com.bancosabadell.monitorAmbientes.catalogos.service;

import java.util.List;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.MONCAmbientesDTO;

public interface MONCAmbientesService {
	List<MONCAmbientesDTO> obtenerAmbientes();
}
