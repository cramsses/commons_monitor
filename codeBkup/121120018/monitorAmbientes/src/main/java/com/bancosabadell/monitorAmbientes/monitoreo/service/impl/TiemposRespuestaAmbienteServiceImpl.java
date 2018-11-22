package com.bancosabadell.monitorAmbientes.monitoreo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.TiempoRespuestaAmbienteDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.TiempoRespuestaAmbienteDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.service.TiemposRespuestaAmbienteService;

@Service
public class TiemposRespuestaAmbienteServiceImpl implements TiemposRespuestaAmbienteService {

	@Autowired
	private TiempoRespuestaAmbienteDAO tiempoRespuestaAmbienteDAO;
	
	public TiemposRespuestaAmbienteServiceImpl() {
	}

	@Override
	public List<TiempoRespuestaAmbienteDTO> obtenerTiempos() {
		return tiempoRespuestaAmbienteDAO.obtenerTiemposRespuestaAmbiente();
	}
}
