package com.bancosabadell.monitorAmbientes.monitoreo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.CaidasAmbienteDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.CaidasAmbienteDTO;
import com.bancosabadell.monitorAmbientes.monitoreo.service.CaidasAmbienteService;

@Service
public class CaidasAmbienteServiceImpl implements CaidasAmbienteService {

	@Autowired
	private CaidasAmbienteDAO caidasAmbienteDAO;
	
	public CaidasAmbienteServiceImpl() {
	}

	@Override
	public List<CaidasAmbienteDTO> obtenerCaidas() {
		return caidasAmbienteDAO.obtenerCaidasAmbiente();
	}

}
