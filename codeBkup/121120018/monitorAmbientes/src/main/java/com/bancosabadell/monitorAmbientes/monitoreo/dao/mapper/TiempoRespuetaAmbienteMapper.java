package com.bancosabadell.monitorAmbientes.monitoreo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bancosabadell.monitorAmbientes.monitoreo.dto.TiempoRespuestaAmbienteDTO;

public class TiempoRespuetaAmbienteMapper implements RowMapper<TiempoRespuestaAmbienteDTO> {

	public TiempoRespuetaAmbienteMapper()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TiempoRespuestaAmbienteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TiempoRespuestaAmbienteDTO objeto = new TiempoRespuestaAmbienteDTO();
		objeto.setIdAmbiente(rs.getInt("IDAMBIENTE"));
		objeto.setAmbiente(rs.getString("NOMBREAMBIENTE"));
		objeto.setHora(rs.getString("HORA"));
		objeto.setTiempoRespAvg(rs.getFloat("AVG"));
		return objeto;
	}

}