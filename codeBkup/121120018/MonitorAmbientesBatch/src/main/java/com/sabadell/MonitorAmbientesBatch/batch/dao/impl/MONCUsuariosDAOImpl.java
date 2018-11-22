package com.sabadell.MonitorAmbientesBatch.batch.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sabadell.MonitorAmbientesBatch.batch.dao.MONCUsuariosDAO;
import com.sabadell.MonitorAmbientesBatch.dto.MONCUsuariosDTO;
import com.sabadell.MonitorAmbientesBatch.mapper.MONCUsuariosMapper;

/**
 * Capa de Acceso a datos de la tabla de usuarios.
 * 
 * @author Jesus Alfredo Henrnandez Orozoc
 *
 */
@Repository
public class MONCUsuariosDAOImpl implements MONCUsuariosDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String OBTENER_USUARIOS_ACTIVOS = "SELECT * FROM MONC_USUARIOS WHERE FECHAFIN IS NULL";

	/**
	 * Obtiene la lista de usuarios activos en el sistema, valida que la fechaFin sea null.
	 */
	@Override
	public List<MONCUsuariosDTO> obtenreUsuariosActivos() {
		return jdbcTemplate.query(OBTENER_USUARIOS_ACTIVOS, new MONCUsuariosMapper());
	}

}
