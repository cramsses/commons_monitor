package com.bancosabadell.monitorAmbientes.monitoreo.dao;

import java.util.List;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibiliadAmbientesDTO;

public interface DisponibiliadAmbientesDAO {

	List<DisponibiliadAmbientesDTO> obtenerDisponibilidad();
}
