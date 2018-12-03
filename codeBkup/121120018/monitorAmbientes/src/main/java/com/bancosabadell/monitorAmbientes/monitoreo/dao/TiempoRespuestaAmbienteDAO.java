package com.bancosabadell.monitorAmbientes.monitoreo.dao;

import java.util.List;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibiliadAmbientesDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.TiempoRespuestaAmbienteDTO;

public interface TiempoRespuestaAmbienteDAO {

	List<TiempoRespuestaAmbienteDTO> obtenerTiemposRespuestaAmbiente();
}
