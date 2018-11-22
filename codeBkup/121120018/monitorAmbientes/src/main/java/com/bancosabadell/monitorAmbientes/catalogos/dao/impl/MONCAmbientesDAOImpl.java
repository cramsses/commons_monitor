package com.bancosabadell.monitorAmbientes.catalogos.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bancosabadell.monitorAmbientes.catalogos.dao.MONCAmbientesDAO;
import com.bancosabadell.monitorAmbientes.catalogos.mapper.MONCAmbientesMapper;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.MONCAmbientesDTO;

@Repository
public class MONCAmbientesDAOImpl implements MONCAmbientesDAO {

	public MONCAmbientesDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	private static final String OBTENER_AMBIENTES = "select * from MONC_AMBIENTES where fechafin is null";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MONCAmbientesDTO> obtenerAmbientes() {
		return jdbcTemplate.query(OBTENER_AMBIENTES, new MONCAmbientesMapper());
	}
}
