package com.sabadell.MonitorAmbientesBatch.batch.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.sabadell.MonitorAmbientesBatch.batch.dao.OperacionDAO;
import com.sabadell.MonitorAmbientesBatch.dto.MONTOperacionDTO;
import com.sabadell.MonitorAmbientesBatch.mapper.OperacionesMapper;

@Repository
public class OperacionDAOImpl implements OperacionDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	private static final String QRY_RETRIEVE_ULTIMA_CORRIDA_OPERACIONES="SELECT opr.*,srv.DESCRIPCIONSERVIDOR \r\n" + 
			"FROM mont_operacion opr  \r\n" + 
			"INNER JOIN mona_servidores srv ON opr.IDSERVIDOR=srv.IDSERVIDOR  \r\n" + 
			"where IDOPERACION = (SELECT MAX(IDOPERACION) FROM mont_operacion)";

	//private static final String QRY_RETRIEVE_SEQUENCE="select mons_operacion.nextval from dual";
	private static final String QRY_RETRIEVE_SEQUENCE="select MONS_OPERACION.nextval from dual";
	
	
	@Override
	public List<MONTOperacionDTO> obtenerDatosRecientes() {
		
		return jdbcTemplate.query(QRY_RETRIEVE_ULTIMA_CORRIDA_OPERACIONES, new OperacionesMapper());
	}

	@Override
	public Integer obtenerSequence() {
		Integer seq=jdbcTemplate.queryForObject(QRY_RETRIEVE_SEQUENCE, Integer.class);
		return seq==null?new Integer(1):seq;
	}
}