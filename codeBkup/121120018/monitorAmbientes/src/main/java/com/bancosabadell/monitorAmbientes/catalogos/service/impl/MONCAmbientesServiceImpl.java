package com.bancosabadell.monitorAmbientes.catalogos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancosabadell.monitorAmbientes.catalogos.dao.MONCAmbientesDAO;
import com.bancosabadell.monitorAmbientes.catalogos.service.MONCAmbientesService;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.MONCAmbientesDTO;

@Service
public class MONCAmbientesServiceImpl implements MONCAmbientesService {

	public MONCAmbientesServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private MONCAmbientesDAO moncAmbientesDAO;

	@Override
	public List<MONCAmbientesDTO> obtenerAmbientes() {
		return moncAmbientesDAO.obtenerAmbientes();
	}

}
