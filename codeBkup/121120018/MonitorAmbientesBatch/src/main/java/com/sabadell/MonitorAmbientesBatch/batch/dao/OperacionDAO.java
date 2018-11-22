package com.sabadell.MonitorAmbientesBatch.batch.dao;

import java.util.List;

import com.sabadell.MonitorAmbientesBatch.dto.MONTOperacionDTO;

public interface OperacionDAO {

	List<MONTOperacionDTO> obtenerDatosRecientes();
	
	Integer obtenerSequence();
}
