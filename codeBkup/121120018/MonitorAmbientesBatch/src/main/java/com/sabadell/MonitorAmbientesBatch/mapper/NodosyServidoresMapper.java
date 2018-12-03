package com.sabadell.MonitorAmbientesBatch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sabadell.MonitorAmbientesBatch.dto.NodosyServidoresDTO;

public class NodosyServidoresMapper implements RowMapper<NodosyServidoresDTO> {
	
	@Override
	public NodosyServidoresDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NodosyServidoresDTO objeto = new NodosyServidoresDTO();
		objeto.setIdServidor(rs.getInt("IDSERVIDOR"));
		objeto.setAmbiente(rs.getString("NOMBREAMBIENTE"));
		objeto.setNodo(rs.getString("NOMNODO"));
		objeto.setDireccion(rs.getString("DIRECCION"));
		objeto.setApp(rs.getString("NOMBREAPP"));
		return objeto;
	}
}