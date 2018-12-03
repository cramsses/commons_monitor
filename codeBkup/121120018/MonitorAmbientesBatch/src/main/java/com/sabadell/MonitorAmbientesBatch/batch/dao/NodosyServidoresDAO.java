package com.sabadell.MonitorAmbientesBatch.batch.dao;

import java.util.List;

import com.sabadell.MonitorAmbientesBatch.dto.NodosyServidoresDTO;

public interface NodosyServidoresDAO {

	List<NodosyServidoresDTO> obtenerDatos();
}
