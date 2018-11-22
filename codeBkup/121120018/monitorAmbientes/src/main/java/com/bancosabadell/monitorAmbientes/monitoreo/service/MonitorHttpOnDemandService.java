package com.bancosabadell.monitorAmbientes.monitoreo.service;

import java.util.List;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.AmbienteConEstatusDTO;

public interface MonitorHttpOnDemandService {
	 List<AmbienteConEstatusDTO> retrieveEstatusByAmbiente();
}
