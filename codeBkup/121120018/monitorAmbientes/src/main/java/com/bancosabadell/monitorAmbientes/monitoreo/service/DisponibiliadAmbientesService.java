package com.bancosabadell.monitorAmbientes.monitoreo.service;

import java.util.List;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibiliadAmbientesDTO;

public interface DisponibiliadAmbientesService {

	List<DisponibiliadAmbientesDTO> obtenerDisponibilidad();
}
