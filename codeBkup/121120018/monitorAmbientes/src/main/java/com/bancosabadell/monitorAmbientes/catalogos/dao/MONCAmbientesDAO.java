package com.bancosabadell.monitorAmbientes.catalogos.dao;

import java.util.List;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.MONCAmbientesDTO;

public interface MONCAmbientesDAO {
	List<MONCAmbientesDTO> obtenerAmbientes();
}
