package com.bancosabadell.monitorAmbientes.monitoreo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.CaidasAmbienteDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper.CaidasAmbienteMapper;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.CaidasAmbienteDTO;

@Repository
public class CaidasAmbienteDAOImpl implements CaidasAmbienteDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final 
	String QRY_CAIDAS_AMBIENTE="SELECT ambi.idambiente, ambi.nombreambiente,to_char(fecha,'HH24:MI') HORA,'1' count\r\n" + 
			"FROM mont_operacion oper \r\n" + 
			"INNER JOIN mona_servidores serv  ON oper.IDSERVIDOR=serv.IDSERVIDOR\r\n" + 
			"INNER JOIN monc_ambientes ambi  ON serv.IDAMBIENTE=ambi.IDAMBIENTE  \r\n" + 
			"WHERE (FECHA >= trunc(sysdate) And FECHA < trunc(sysdate) + 1)      \r\n" + 
			"AND oper.IDESTATUS not in (200, 401)\r\n" + 
			"group by ambi.idambiente,ambi.nombreambiente,to_char(fecha,'HH24:MI')";
//	String QRY_CAIDAS_AMBIENTE="SELECT ambi.idambiente, ambi.nombreambiente, to_char(fecha, 'HH24') hora, count(ambi.idambiente) count\r\n" + 
//			"FROM mont_operacion oper  \r\n" + 
//			"INNER JOIN mona_servidores serv  ON oper.IDSERVIDOR=serv.IDSERVIDOR  \r\n" + 
//			"INNER JOIN monc_ambientes ambi  ON serv.IDAMBIENTE=ambi.IDAMBIENTE   \r\n" + 
//			"WHERE (FECHA >= trunc(sysdate) And FECHA < trunc(sysdate) + 1)       \r\n" + 
//			"AND oper.IDESTATUS not in (200, 401) \r\n" + 
//			"GROUP BY ambi.IDAMBIENTE, ambi.nombreambiente, to_char(fecha, 'HH24')";


	@Override
	public List<CaidasAmbienteDTO> obtenerCaidasAmbiente() {
		return jdbcTemplate.query(QRY_CAIDAS_AMBIENTE, new CaidasAmbienteMapper());
	}
}