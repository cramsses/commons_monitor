package com.bancosabadell.monitorAmbientes.monitoreo.dao;

import java.util.List;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.NodosyServidoresDTO;

public interface NodosyServidoresDAO {

	List<NodosyServidoresDTO> obtenerDatos();
}
