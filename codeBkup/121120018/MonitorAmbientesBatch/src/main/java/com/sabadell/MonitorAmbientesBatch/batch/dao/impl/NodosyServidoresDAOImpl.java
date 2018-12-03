package com.sabadell.MonitorAmbientesBatch.batch.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sabadell.MonitorAmbientesBatch.batch.dao.NodosyServidoresDAO;
import com.sabadell.MonitorAmbientesBatch.dto.NodosyServidoresDTO;
import com.sabadell.MonitorAmbientesBatch.mapper.NodosyServidoresMapper;

@Repository
public class NodosyServidoresDAOImpl implements  NodosyServidoresDAO {

	
    private static final String OBTENER_NODOSYSERVIODORES =
        "select b.IDSERVIDOR, a.NOMBREAMBIENTE, c.NOMNODO, d.DIRECCION, e.NOMBREAPP \r\n" + 
        "from monc_ambientes a \r\n" + 
        "inner join mona_servidores b on (a.IDAMBIENTE = b.IDAMBIENTE) \r\n" + 
        "inner join monc_nodos      c on (c.idnodo = b.IDNODO) \r\n" + 
        "inner join mona_url        d on (d.IDURL = b.IDURL) \r\n" + 
        "inner join monc_aplicacion e on (e.idapp = d.IDTIPOAPP) \r\n" + 
        "order by a.IDAMBIENTE,  e.IDAPP, c.idnodo";
    
	public NodosyServidoresDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<NodosyServidoresDTO> obtenerDatos() {
		return jdbcTemplate.query(OBTENER_NODOSYSERVIODORES, new NodosyServidoresMapper());
	}

}
