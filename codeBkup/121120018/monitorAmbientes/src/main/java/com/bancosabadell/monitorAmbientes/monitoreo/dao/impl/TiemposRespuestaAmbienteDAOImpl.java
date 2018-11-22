package com.bancosabadell.monitorAmbientes.monitoreo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.TiempoRespuestaAmbienteDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper.TiempoRespuetaAmbienteMapper;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.TiempoRespuestaAmbienteDTO;

@Repository
public class TiemposRespuestaAmbienteDAOImpl implements TiempoRespuestaAmbienteDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final 
	String QRY_TIEMPO_RESPUESTA_AMBIENTE="SELECT ambi.idambiente, ambi.NOMBREAMBIENTE, to_char(FECHA, 'HH24') as HORA, AVG(oper.TIEMPORESPUESTA) as AVG \r\n" + 
			"FROM mont_operacion oper  \r\n" + 
			"INNER JOIN mona_servidores serv  ON oper.IDSERVIDOR=serv.IDSERVIDOR  \r\n" + 
			"INNER JOIN monc_ambientes ambi  ON serv.IDAMBIENTE=ambi.IDAMBIENTE  \r\n" + 
			"WHERE (FECHA >= trunc(sysdate) And FECHA < trunc(sysdate) + 1) \r\n" + 
			"GROUP BY ambi.IDAMBIENTE, ambi.NOMBREAMBIENTE, to_char(FECHA, 'HH24')\r\n" + 
			"order by ambi.idambiente";

	@Override
	public List<TiempoRespuestaAmbienteDTO> obtenerTiemposRespuestaAmbiente() {
		return jdbcTemplate.query(QRY_TIEMPO_RESPUESTA_AMBIENTE, new TiempoRespuetaAmbienteMapper());
	}
}