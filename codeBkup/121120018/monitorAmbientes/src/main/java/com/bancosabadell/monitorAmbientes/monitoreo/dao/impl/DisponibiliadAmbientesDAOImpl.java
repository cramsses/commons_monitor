package com.bancosabadell.monitorAmbientes.monitoreo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.DisponibiliadAmbientesDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper.DisponibiliadAmbientesMapper;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibiliadAmbientesDTO;

@Repository
public class DisponibiliadAmbientesDAOImpl implements DisponibiliadAmbientesDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String OBTENER_DISPONIBILIDAD = "select d.NOMBREAMBIENTE, round(((d.ok*100)/(d.errores + d.ok ))) as disponibilidad  \r\n" + 
			"from (\r\n" + 
			"select c.idambiente, c.NOMBREAMBIENTE, sum(case when (a.IDESTATUS=200 or a.IDESTATUS=401) then 1 else 0 end) as OK, \r\n" + 
			"sum(case when a.IDESTATUS not in (200,401) then 1 else 0 end) as errores \r\n" + 
			"from mont_operacion a \r\n" + 
			"inner join mona_servidores b on (a.idservidor=b.idservidor)  \r\n" + 
			"inner join monc_ambientes  c on (c.IDAMBIENTE=b.IDAMBIENTE) \r\n" + 
			"where c.idambiente <>9 and (a.FECHA >= trunc(sysdate) And a.FECHA < trunc(sysdate) + 1) \r\n" + 
			"group by c.idambiente, c.NOMBREAMBIENTE\r\n" + 
            ") d ";
	
	@Override
	public List<DisponibiliadAmbientesDTO> obtenerDisponibilidad() {
		return jdbcTemplate.query(OBTENER_DISPONIBILIDAD, new DisponibiliadAmbientesMapper());
	}
}