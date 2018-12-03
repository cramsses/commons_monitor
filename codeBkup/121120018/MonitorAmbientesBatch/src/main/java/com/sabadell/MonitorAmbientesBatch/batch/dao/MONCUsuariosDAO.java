package com.sabadell.MonitorAmbientesBatch.batch.dao;

import java.util.List;

import com.sabadell.MonitorAmbientesBatch.dto.MONCUsuariosDTO;

/**
 * Capa de Acceso a datos de la tabla de usuarios.
 * 
 * @author Jesus Alfredo Henrnandez Orozoc
 *
 */
public interface MONCUsuariosDAO {

	/**
	 * Obtiene la lista de usuarios activos en el sistema, valida que la fechaFin sea null.
	 */
	List<MONCUsuariosDTO> obtenreUsuariosActivos();

}
