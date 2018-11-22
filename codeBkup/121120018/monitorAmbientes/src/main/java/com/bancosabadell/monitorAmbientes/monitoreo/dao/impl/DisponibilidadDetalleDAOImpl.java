package com.bancosabadell.monitorAmbientes.monitoreo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bancosabadell.monitorAmbientes.monitoreo.dao.DisponibilidadDetalleDAO;
import com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper.DisponibilidadDetalleMapper;
import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibilidadDetalleDTO;

@Repository
public class DisponibilidadDetalleDAOImpl implements DisponibilidadDetalleDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	@Override
	public List<DisponibilidadDetalleDTO> obtenerDisponibilidadDetalle(String query) {
		return jdbcTemplate.query(query, new DisponibilidadDetalleMapper());
	}

}
