package com.bancosabadell.monitorAmbientes.monitoreo.dao;

import java.util.List;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.CaidasAmbienteDTO;

public interface CaidasAmbienteDAO {

	List<CaidasAmbienteDTO> obtenerCaidasAmbiente();
}
