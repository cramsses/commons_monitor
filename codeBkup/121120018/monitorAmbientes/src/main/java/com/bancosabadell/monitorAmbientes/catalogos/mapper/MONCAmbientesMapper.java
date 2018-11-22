package com.bancosabadell.monitorAmbientes.catalogos.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.MONCAmbientesDTO;

public class MONCAmbientesMapper implements RowMapper<MONCAmbientesDTO> {

	public MONCAmbientesMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MONCAmbientesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MONCAmbientesDTO objeto = new MONCAmbientesDTO();
		objeto.setIdAmbiente(rs.getInt("IDAMBIENTE"));
		objeto.setNombreAmbiente(rs.getString("NOMBREAMBIENTE"));
		objeto.setNombreCorto(rs.getString("NOMBRECORTO"));
		objeto.setDescripcionAmbiente(rs.getString("DESCRIPCIONAMBIENTE"));
		objeto.setFechaInicio(rs.getDate("FECHAINICIO"));
		objeto.setFechaFin(rs.getDate("FECHAFIN"));
		return objeto;
	}
}
