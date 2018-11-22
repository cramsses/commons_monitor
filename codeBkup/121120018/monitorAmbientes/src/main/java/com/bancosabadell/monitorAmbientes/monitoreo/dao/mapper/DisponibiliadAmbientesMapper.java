package com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.DisponibiliadAmbientesDTO;

public class DisponibiliadAmbientesMapper implements RowMapper<DisponibiliadAmbientesDTO> {

	public DisponibiliadAmbientesMapper()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DisponibiliadAmbientesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DisponibiliadAmbientesDTO objeto = new DisponibiliadAmbientesDTO();
		objeto.setAmbiente(rs.getString("NOMBREAMBIENTE"));
		objeto.setDisponibilidad(rs.getFloat("DISPONIBILIDAD"));
		return objeto;
	}

}