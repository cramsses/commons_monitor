package com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.NodosyServidoresDTO;

public class NodosyServidoresMapper implements RowMapper<NodosyServidoresDTO> {
	
	@Override
	public NodosyServidoresDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NodosyServidoresDTO objeto = new NodosyServidoresDTO();
		objeto.setIdAmbiente(rs.getInt("IDAMBIENTE"));
		objeto.setAmbiente(rs.getString("NOMBREAMBIENTE"));
		objeto.setNombreCorto(rs.getString("NOMBRECORTO"));
		objeto.setNodo(rs.getString("NOMNODO"));
		objeto.setDireccion(rs.getString("DIRECCION"));
		objeto.setApp(rs.getString("NOMBREAPP"));
		return objeto;
	}

}
