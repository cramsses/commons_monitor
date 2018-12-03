package com.bancosabadell.monitorAmbientes.monitoreo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.NodosyServidoresDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper.NodosyServidoresMapper;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.NodosyServidoresDTO;

/**
 * Clase que obtiene los datos de la lista de servidores y nodos por ambiente.
 * 
 * @author Jesus Alfredo Hernandez Orozco
 */
@Repository
public class NodosyServidoresDAOImpl implements NodosyServidoresDAO {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String OBTENER_LISTA_SERVIDORES="select a.idambiente, a.NOMBREAMBIENTE, a.NOMBRECORTO, c.NOMNODO, d.DIRECCION, e.NOMBREAPP\r\n" + 
			"from monc_ambientes a\r\n" + 
			"inner join mona_servidores b on (a.IDAMBIENTE = b.IDAMBIENTE)\r\n" + 
			"inner join monc_nodos      c on (c.idnodo = b.IDNODO)\r\n" + 
			"inner join mona_url        d on (d.IDURL = b.IDURL)\r\n" + 
			"inner join monc_aplicacion e on (e.idapp = d.IDTIPOAPP)\r\n" + 
            "order by a.IDAMBIENTE,  e.IDAPP, c.idnodo";
	
	@Override
	public List<NodosyServidoresDTO> obtenerDatos() {
		return jdbcTemplate.query(OBTENER_LISTA_SERVIDORES,new NodosyServidoresMapper());
	}

	
}
