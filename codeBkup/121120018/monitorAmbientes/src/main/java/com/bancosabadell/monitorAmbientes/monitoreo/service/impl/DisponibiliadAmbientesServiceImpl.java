package com.bancosabadell.monitorAmbientes.monitoreo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.DisponibiliadAmbientesDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibiliadAmbientesDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.service.DisponibiliadAmbientesService;

@Service
public class DisponibiliadAmbientesServiceImpl implements DisponibiliadAmbientesService {

	public DisponibiliadAmbientesServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private DisponibiliadAmbientesDAO disponibiliadAmbientesDAO;
	
	@Override
	public List<DisponibiliadAmbientesDTO> obtenerDisponibilidad() {
		return disponibiliadAmbientesDAO.obtenerDisponibilidad();
	}

}
