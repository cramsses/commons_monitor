package com.bancosabadell.monitorAmbientes.servicios.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bancosabadell.monitorAmbientes.servicios.dao.ServiciosAdicionalesDAO;

/**
 * Obtiene distintos valores de la base de datos.
 * 
 * @author Jesus Alfredo Hernandez Orozco.
 *
 */
@Repository
public class ServiciosAdicionalesDAOImpl implements ServiciosAdicionalesDAO {

	public ServiciosAdicionalesDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static final String OBTENER_HORA = "select SYSDATE from dual";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Obtiene la hora de la base de datos.
	 */
	@Override
	public Date obtenerHoraDelSistema() {
		return jdbcTemplate.queryForObject(OBTENER_HORA, Date.class);
	}

}
